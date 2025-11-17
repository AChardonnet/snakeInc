package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.Direction;

public final class GoodHealth extends SnakeState {

    public GoodHealth(Snake snake) {
        super(snake);
    }

    @Override
    public Direction movementModifier(Direction direction) {
        return direction;
    }

    @Override
    public void eatPoison() {
        snake.setState(new Poisoned(snake));
    }

    @Override
    public void eatBrocolis() {

    }
}
