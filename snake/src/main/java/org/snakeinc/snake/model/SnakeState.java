package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.Direction;

public abstract sealed class SnakeState permits GoodHealth, PermanentlyDamaged, Poisoned {
    protected Snake snake;

    SnakeState(Snake snake) {
        this.snake = snake;
    }

    public abstract Direction movementModifier(Direction direction);
    public abstract void eatPoison();
    public abstract void eatBrocolis();
}
