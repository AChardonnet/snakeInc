package org.snakeinc.snake.model;

import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.utils.SnakeColor;

public final class Anaconda extends Snake {
    public Anaconda(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.GRAY);
    }

    @Override
    public void eat(Food food, Cell cell) throws DiedOfMalnutritionException {
        switch (food.getFoodType()) {
            case APPLE:
                body.addFirst(cell);
                cell.addSnake(this);
                onAppleEatenListener.onAppleEaten(food, cell);
                break;
            case BROCOLIS:
                if (body.size() <= 2) {
                    throw new DiedOfMalnutritionException();
                }

                body.getLast().removeSnake();
                body.removeLast();
                body.getLast().removeSnake();
                body.removeLast();

                onAppleEatenListener.onAppleEaten(food, cell);
                break;
        }
    }
}
