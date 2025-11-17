package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.FoodType;

public class FoodFactory {

    public static Food createAppleInCell(Cell cell) {
        Food apple = new Food(FoodType.APPLE);
        cell.addFood(apple);
        return apple;
    }

    public static Food createBrocolisInCell(Cell cell) {
        Food brocolis = new Food(FoodType.BROCOLIS);
        cell.addFood(brocolis);
        return brocolis;
    }

}
