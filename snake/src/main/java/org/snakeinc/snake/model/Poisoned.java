package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.Direction;

public final class Poisoned extends SnakeState {
    public Poisoned(Snake snake) {
        super(snake);
    }

    @Override
    public Direction movementModifier(Direction direction) {
        Direction newDirection = direction;
        switch (direction) {
            case D -> newDirection = Direction.U;
            case U -> newDirection = Direction.D;
        }
        return newDirection;
    }

    @Override
    public void eatPoison() {
        snake.setState(new PermanentlyDamaged(snake));
    }

    @Override
    public void eatBrocolis() {
        snake.setState(new GoodHealth(snake));
    }
}
