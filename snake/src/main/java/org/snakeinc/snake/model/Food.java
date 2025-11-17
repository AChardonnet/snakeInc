package org.snakeinc.snake.model;

import lombok.Getter;
import org.snakeinc.snake.utils.FoodType;

@Getter
public abstract sealed class Food permits Apple, Brocolis {
    protected FoodType foodType;

    public Food(FoodType foodType) {
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}
