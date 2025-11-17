package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.FoodType;

public final class Brocolis extends Food{
    private boolean steamed;

    public Brocolis(boolean steamed) {
        super(FoodType.BROCOLIS);
        this.steamed = steamed;
    }

    public boolean isSteamed() {
        return steamed;
    }
}
