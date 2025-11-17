package org.snakeinc.snake.model;

import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.utils.SnakeColor;

public final class BoaConstrictor extends Snake {
    public BoaConstrictor(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.BLUE);
    }

    @Override
    public void eat(Food food, Cell cell) throws DiedOfMalnutritionException {
        fruits++;
        updateScore(food);
        switch (food.getFoodType()) {
            case APPLE:
                if (body.size() <= 1) {
                    throw new DiedOfMalnutritionException();
                }
                onAppleEatenListener.onAppleEaten(food, cell);

                body.getLast().removeSnake();
                body.removeLast();
                break;
            case BROCOLIS:
                onAppleEatenListener.onAppleEaten(food, cell);
                break;
        }
    }
}
