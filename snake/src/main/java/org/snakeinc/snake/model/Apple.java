package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.FoodType;

public final class Apple extends Food{
    private boolean poisoned;

    public Apple(boolean poisoned) {
        super(FoodType.APPLE);
        this.poisoned = poisoned;
    }

    public boolean isPoisoned() {
        return poisoned;
    }
}
