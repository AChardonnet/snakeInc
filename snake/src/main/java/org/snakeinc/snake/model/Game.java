package org.snakeinc.snake.model;

import lombok.Getter;
import org.snakeinc.snake.exception.DiedOfMalnutritionException;
import org.snakeinc.snake.exception.OutOfPlayException;
import org.snakeinc.snake.exception.SelfCollisionException;
import org.snakeinc.snake.utils.Direction;

import java.util.Random;

@Getter
public class Game {

    private final Grid grid;
    private final Basket basket;
    private final Snake snake;

    public Game() {
        Random random = new Random();
        String[] snakes = {"Anaconda", "BoaConstrictor", "Python"};
        grid = new Grid();
        basket = new Basket(grid);
        basket.refillIfNeeded(1);
        switch (snakes[random.nextInt(snakes.length)]) {
            case "Anaconda":
                snake = new Anaconda((apple, cell) -> basket.removeFoodInCell(apple, cell), grid);
                break;
            case "BoaConstrictor":
                snake = new BoaConstrictor((apple, cell) -> basket.removeFoodInCell(apple, cell), grid);
                break;
            default:
                snake = new Python((apple, cell) -> basket.removeFoodInCell(apple, cell), grid);
                break;

        }
        System.out.println(snake);
    }

    public void iterate(Direction direction) throws OutOfPlayException, SelfCollisionException, DiedOfMalnutritionException {
        snake.move(direction);
        basket.refillIfNeeded(1);
    }


}
