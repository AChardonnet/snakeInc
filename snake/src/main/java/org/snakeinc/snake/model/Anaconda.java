package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.SnakeColor;

public final class Anaconda extends Snake {
    public Anaconda(AppleEatenListener listener, Grid grid) {
        super(listener, grid, SnakeColor.GRAY);
    }
}
