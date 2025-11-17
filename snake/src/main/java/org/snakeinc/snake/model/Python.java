package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.SnakeColor;

public final class Python extends Snake{
    public Python(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.GREEN);

    }

    @Override
    public void eat(Apple apple, Cell cell) {
        onAppleEatenListener.onAppleEaten(apple, cell);
    }
}
