package org.snakeinc.snake.model;

import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.utils.SnakeColor;

public final class BoaConstrictor extends Snake {
    public BoaConstrictor(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.BLUE);
    }

    @Override
    public void eat(Apple apple, Cell cell) throws DiedOfMalnutritionException {
        if (body.size() == 1) {
            throw new DiedOfMalnutritionException();
        }
        onAppleEatenListener.onAppleEaten(apple, cell);

        body.getLast().removeSnake();
        body.removeLast();
    }
}
