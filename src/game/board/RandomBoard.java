package game.board;

import java.util.*;

import game.exception.IllegalGameActionException;
import game.exception.UnknownTileException;
import game.tile.DesertTile;
import game.tile.ForestTile;
import game.tile.MountainTile;
import game.tile.OceanTile;
import game.tile.PlainTile;
import game.tile.Tile;
import game.unit.Unit;

/**
 * A class to model the board in different games. A board is composed of tiles
 * of different types and is defined by a width and a height. A board is created
 * following two rules: at least 2 in 3 tiles are of type ocean, and all tile
 * that is not of type ocean must have a neighboring tile which isn't either
 */
public class RandomBoard extends Board {
    /**
     * Construct a board defined by its width (horizontal size) and a height
     * (vertical size), representing numbers of tiles
     * @param width Horizontal size in number of tiles
     * @param height Vertical size in number of tiles
     * @throws IllegalArgumentException iff <code>width</code> is less than 2 or
     * <code>height</code> is less than 1
     */
    public RandomBoard(int width, int height) throws IllegalArgumentException {
    	super(width, height);
        this.populate();
    }

    /* Initialize the tile of the board (following the constraints) */
    private void populate() {
        int numTiles = this.width * this.height;
        int numPrimary = numTiles / 6;
        Set<Integer> primaryCodes = choosePrimary(numPrimary, numTiles);
        initializePrimary(primaryCodes);
        initializeSecondary(primaryCodes);
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.tiles[i][j] == null) {
                    this.tiles[i][j] = new OceanTile(j, i);
                }
            }
        }
    }

    /* Return a set of integers between 0 and width * height */
    private Set<Integer> choosePrimary(int numPrimary, int numTiles) {
        int count = 0;
        Set<Integer> tileCodes = new HashSet<Integer>();
        while (count < numPrimary) {
            int code = this.source.nextInt(numTiles);
            if (tileCodes.add(code)) {
                count++;
            }
        }
        return tileCodes;
    }

    /* Initialize each tile in the set passed as argument */
    private void initializePrimary(Set<Integer> primaryCodes) {
        for (int code : primaryCodes) {
            initializeTile(code % this.width, code / this.width);
        }
    }

    /* For each tile from the set, if the tile is the first of its row,
     * initialize its right neighbor if not already initialized. If the tile
     * is not the first of its row, initialize its left neighbor if not
     * already initialized */
    private void initializeSecondary(Set<Integer> primaryCodes) {
        for (int code : primaryCodes) {
            if (code % this.width == 0) {
                if (this.tiles[code / this.width][1] == null) {
                    initializeTile(1, code / this.width);
                }
            }
            else {
                if (this.tiles[code / this.width][(code % this.width) - 1] == null) {
                    initializeTile((code % this.width) - 1, code / this.width);
                }
            }
        }
    }

    /* Initialize this.tiles[y][x] with a random terrain type (except Ocean) */
    private void initializeTile(int x, int y)  {
        int roll = this.source.nextInt(4);
        switch (roll) {
        case 0:
            this.tiles[y][x] = new DesertTile(x, y);
            break;
        case 1:
            this.tiles[y][x] = new MountainTile(x, y);
            break;
        case 2:
            this.tiles[y][x] = new ForestTile(x, y);
            break;
        case 3:
            this.tiles[y][x] = new PlainTile(x, y);
            break;
        }
    }

    /** Random source used to generate the board */
    private static Random source = new Random();
}
