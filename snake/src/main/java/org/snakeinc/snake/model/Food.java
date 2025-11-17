package org.snakeinc.snake.model;

import lombok.Getter;
import org.snakeinc.snake.utils.FoodType;

@Getter
public class Food {
    protected FoodType foodType;

    public Food(FoodType foodType) {
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}
