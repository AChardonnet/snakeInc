package org.snakeinc.snake.model;

import java.util.ArrayList;

import org.snakeinc.snake.GameParams;
import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.exception.OutOfPlayException;
import org.snakeinc.snake.exception.SelfCollisionException;
import org.snakeinc.snake.utils.SnakeColor;
import org.snakeinc.snake.utils.Direction;

public abstract sealed class Snake permits Anaconda, BoaConstrictor, Python {

    protected final ArrayList<Cell> body;
    protected final AppleEatenListener onAppleEatenListener;
    protected final Grid grid;
    protected final SnakeColor snakeColor;

    public Snake(AppleEatenListener listener, Grid grid, SnakeColor snakeColor) {
        this.snakeColor = snakeColor;
        this.body = new ArrayList<>();
        this.onAppleEatenListener = listener;
        this.grid = grid;
        Cell head = grid.getTile(GameParams.SNAKE_DEFAULT_X, GameParams.SNAKE_DEFAULT_Y);
        head.addSnake(this);
        body.add(head);
        Cell bodySegment = grid.getTile(GameParams.SNAKE_DEFAULT_X - 1, GameParams.SNAKE_DEFAULT_Y - 1);
        bodySegment.addSnake(this);
        body.add(bodySegment);
        bodySegment = grid.getTile(GameParams.SNAKE_DEFAULT_X - 2, GameParams.SNAKE_DEFAULT_Y - 2);
        bodySegment.addSnake(this);
        body.add(bodySegment);
    }

    public int getSize() {
        return body.size();
    }

    public Cell getHead() {
        return body.getFirst();
    }

    public SnakeColor getSnakeColor() {
        return snakeColor;
    }

    public void eat(Food apple, Cell cell) throws DiedOfMalnutritionException {
        body.addFirst(cell);
        cell.addSnake(this);
        onAppleEatenListener.onAppleEaten(apple, cell);
    }

    public void move(Direction direction) throws OutOfPlayException, SelfCollisionException, DiedOfMalnutritionException {
        int x = getHead().getX();
        int y = getHead().getY();
        switch (direction) {
            case U:
                y--;
                break;
            case D:
                y++;
                break;
            case L:
                x--;
                break;
            case R:
                x++;
                break;
        }
        Cell newHead = grid.getTile(x, y);
        if (newHead == null) {
            throw new OutOfPlayException();
        }
        if (newHead.containsASnake()) {
            throw new SelfCollisionException();
        }

        // Eat apple :
        if (newHead.containsAFood()) {
            this.eat(newHead.getFood(), newHead);
            return;
        }

        // The snake did not eat :
        newHead.addSnake(this);
        body.addFirst(newHead);

        body.getLast().removeSnake();
        body.removeLast();

    }

}
