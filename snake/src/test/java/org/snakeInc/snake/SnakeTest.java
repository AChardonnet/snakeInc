package org.snakeInc.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.snakeinc.snake.exception.OutOfPlayException;
import org.snakeinc.snake.exception.SelfCollisionException;
import org.snakeinc.snake.model.Game;
import org.snakeinc.snake.utils.Direction;

import static org.snakeinc.snake.GameParams.SNAKE_DEFAULT_Y;

public class SnakeTest {

    Game game = new Game();

    @Test
    public void snakeEatApplesAfterMove_ReturnsCorrectBodySize() throws OutOfPlayException, SelfCollisionException {
        game.getBasket().addApple(game.getGrid().getTile(5, 4));
        game.getSnake().move(Direction.U);
        Assertions.assertEquals(2, game.getSnake().getSize());
    }

    @Test
    void snakeMovesUp_ReturnCorrectHead() throws OutOfPlayException, SelfCollisionException {
        game.getSnake().move(Direction.U);
        Assertions.assertEquals(5, game.getSnake().getHead().getX());
        Assertions.assertEquals(4, game.getSnake().getHead().getY());
    }

    @Test
    public void snakeOutOfGame_Throws_OutOfPlayException() throws OutOfPlayException, SelfCollisionException {
        for (int i = 0; i < SNAKE_DEFAULT_Y ; i++) {
            game.getSnake().move(Direction.U);
        }
        Assertions.assertThrows(OutOfPlayException.class, () -> game.getSnake().move(Direction.U));
    }

    @Test
    public void snakeSelfCollides_Throws_SelfCollisionException() throws OutOfPlayException, SelfCollisionException {
        for (int i = 0; i < 4 ; i++) {
            game.getBasket().addApple(game.getGrid().getTile(5, 4 - i));
            game.getSnake().move(Direction.U);
        }
        game.getSnake().move(Direction.L);
        game.getSnake().move(Direction.D);
        Assertions.assertThrows(SelfCollisionException.class, () -> game.getSnake().move(Direction.R));
    }
}
