package org.snakeinc.snake.model;

import java.util.Random;
import lombok.Getter;

public class Apple implements GameObject {

    @Getter
    private Tile tile;
    private final Random random;

    public Apple() {
        random = new Random();
        tile = Grid.getInstance().getTile(random.nextInt(0, Grid.TILES_X), random.nextInt(0, Grid.TILES_Y));
        tile.gameObjectsInTile.add(this);
    }

}
