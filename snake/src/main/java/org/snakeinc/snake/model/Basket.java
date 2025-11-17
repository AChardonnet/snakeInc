package org.snakeinc.snake.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Data;
import org.snakeinc.snake.GameParams;
import org.snakeinc.snake.utils.FoodType;

@Data
public class Basket {

    private Grid grid;
    private List<Food> foods;

    public Basket(Grid grid) {
        foods = new ArrayList<>();
        this.grid = grid;
    }

    public void addApple(Cell cell) {
        if (cell == null) {
            var random = new Random();
            boolean inSnake = true;
            while (inSnake) {
                cell = grid.getTile(random.nextInt(0, GameParams.TILES_X), random.nextInt(0, GameParams.TILES_Y));
                inSnake = cell.containsASnake();
            }
        }
        Food food = FoodFactory.createAppleInCell(cell);
        foods.add(food);
    }

    public void addBroccolis(Cell cell) {
        if (cell == null) {
            var random = new Random();
            boolean inSnake = true;
            while (inSnake) {
                cell = grid.getTile(random.nextInt(0, GameParams.TILES_X), random.nextInt(0, GameParams.TILES_Y));
                inSnake = cell.containsASnake();
            }
        }
        Food food = FoodFactory.createBrocolisInCell(cell);
        foods.add(food);
    }

    public void removeFoodInCell(Food food, Cell cell) {
        cell.removeFood();
        foods.remove(food);
    }

    public boolean isEmpty() {
        return foods.isEmpty();
    }

    private void refill(int nFoods) {
        for (int i = 0; i < nFoods; i++) {
            FoodType[] foodTypes = FoodType.values();
            Random random = new Random();
            switch (foodTypes[random.nextInt(foodTypes.length)]) {
                case APPLE:
                    addApple(null);
                    break;
                default:
                    addBroccolis(null);
                    break;
            }
        }
    }

    public void refillIfNeeded(int nFoods) {
        int missingFoods = nFoods - foods.size();
        if (missingFoods > 0) {
            refill(missingFoods);
        }
    }

}
