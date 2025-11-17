package org.snakeinc.snake.model;

import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.utils.SnakeColor;

public final class Python extends Snake {
    public Python(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.GREEN);

    }

    @Override
    public void eat(Food food, Cell cell) throws DiedOfMalnutritionException {
        fruits++;
        updateScore(food);
        switch (food) {
            case Apple a:
                onAppleEatenListener.onAppleEaten(food, cell);
                break;
            case Brocolis b:
                if (body.size() <= 3) {
                    throw new DiedOfMalnutritionException();
                }

                body.getLast().removeSnake();
                body.removeLast();
                body.getLast().removeSnake();
                body.removeLast();
                body.getLast().removeSnake();
                body.removeLast();

                onAppleEatenListener.onAppleEaten(food, cell);
                break;
        }
    }
}
