package org.snakeinc.snake.model;

import org.snakeinc.snake.utils.FoodType;

import java.util.Random;

public class FoodFactory {
    private static Random random = new Random();

    public static Food createAppleInCell(Cell cell) {
        Food apple = new Apple(random.nextBoolean());
        cell.addFood(apple);
        return apple;
    }

    public static Food createBrocolisInCell(Cell cell) {
        Food brocolis = new Brocolis(random.nextBoolean());
        cell.addFood(brocolis);
        return brocolis;
    }

}
