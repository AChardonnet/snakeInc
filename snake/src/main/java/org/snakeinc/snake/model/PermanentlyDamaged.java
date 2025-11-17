package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.Direction;

public final class PermanentlyDamaged extends SnakeState {
    public PermanentlyDamaged(Snake snake) {
        super(snake);
    }

    @Override
    public Direction movementModifier(Direction direction) {
        Direction newDirection = direction;
        switch (direction) {
            case D -> newDirection = Direction.U;
            case U -> newDirection = Direction.D;
            case L -> newDirection = Direction.R;
            case R -> newDirection = Direction.L;
        }
        return newDirection;
    }

    @Override
    public void eatPoison() {

    }

    @Override
    public void eatBrocolis() {

    }
}
