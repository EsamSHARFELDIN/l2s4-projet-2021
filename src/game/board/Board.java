package game.board;

import java.util.*;

import game.exception.IllegalGameActionException;
import game.exception.UnknownTileException;
import game.tile.Tile;
import game.unit.Unit;

/**
 * A class to model the board in different games. A board is composed of tiles
 * of different types and is defined by a width and a height.
 * @version 15/03/21
 */
public abstract class Board {
    /**
     * Construct a board defined by its width (horizontal size) and a height
     * (vertical size), representing numbers of tiles
     * @param width Horizontal size in number of tiles
     * @param height Vertical size in number of tiles
     * @throws IllegalArgumentException iff <code>width</code> is less than 2 or
     * <code>height</code> is less than 1
     */
    public Board(int width, int height) throws IllegalArgumentException {
        if (width < 1) {
            throw new IllegalArgumentException("Board: invalid width in constructor");
        }
        if (height < 1) {
            throw new IllegalArgumentException("Board: invalid height in constructor");
        }

        this.tiles = new Tile[height][width];
        this.width = width;
        this.height = height;
        // this.populate();
    }

    /**
     * Check whether the board is full, i.e whether all of the occupable tiles
     * are currently occupied by units
     * @return <code>true</code> if all tiles are occupied, else
     * <code>false</code>*/
    public boolean isFull() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (!this.tiles[i][j].isBusy()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return the tile located at the position of the board defined by the
     * coordinates passed as parameters
     * @param x Horizontal coordinate, should be an integer between
     * <code>0</code> and <code>width - 1</code>
     * @param y Vertical coordinate, should be an integer between
     * <code>0</code> and <code>height - 1</code>
     * @return The tile at the specified location
     * @throws UnknownTileException iff either <code>x</code> or <code>y</code>
     * is out of the specified bounds
     */
    public Tile tileAt(int x, int y) throws UnknownTileException {
        try {
            return this.tiles[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnknownTileException("Tile is out of bounds");
        }
    }

    /**
     * Set the unit located at the position of the board defined by the
     * coordinates passed as parameters
     * @param x Horizontal coordinate, should be an integer between
     * <code>0</code> and <code>width - 1</code>
     * @param y Vertical coordinate, should be an integer between
     * <code>0</code> and <code>height - 1</code>
     * @param unit Unit to position on the tile specified by the coordinates
     * @throws UnknownTileException iff either <code>x</code> or <code>y</code>
     * is out of the specified bounds
     * @throws IllegalGameActionException iff the unit could not be deployed
     * on the specified tile
     */
    public void setUnitAt(int x, int y, Unit unit)
        throws UnknownTileException, IllegalGameActionException {
        try {
            this.tiles[y][x].setUnit(unit);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new UnknownTileException("Tile is out of bounds");
        }
    }

    /**
     * Return the neighboring tiles of the tile which occupies the specified
     * coordinates on the board as an array of tiles. The neighboring tiles
     * occupy the position at the north, west, south and east of the specified
     * tile
     * @param x Horizontal coordinate, should be an integer between
     * <code>0</code> and <code>width - 1</code>
     * @param y Vertical coordinate, should be an integer between
     * <code>0</code> and <code>height - 1</code>
     * @return A list of tiles representing the neighboring tiles. The list
     * may contain 2, 3 or 4 elements depending on the position of the initial
     * tile
     * @throws UnknownTileException iff either <code>x</code> or <code>y</code>
     * is out of the specified bounds
     */
    public List<Tile> adjacentTiles(int x, int y) throws UnknownTileException {
        List<Tile> tiles = new ArrayList<Tile>();
        if (y > 0) {
            tiles.add(this.tiles[y - 1][x]);
        }
        if (y < this.height - 1) {
            tiles.add(this.tiles[y + 1][x]);
        }
        if (x > 0) {
            tiles.add(this.tiles[y][x - 1]);
        }
        if (x < this.width - 1) {
            tiles.add(this.tiles[y][x + 1]);
        }
        return tiles;
    }

    /**
     * Return a list of the tiles that are not occupied by any unit
     * @return List of unoccupied tiles
     */
    public List<Tile> freeTiles() {
        List<Tile> tiles = new ArrayList<Tile>();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (!this.tiles[i][j].isBusy()) {
                    tiles.add(this.tiles[i][j]);
                }
            }
        }
        return tiles;
    }

    public void print() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print("[");
                this.tiles[i][j].print();
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    /** Two-dimensional array of tiles, used to represent the game world */
    protected Tile[][] tiles;

    /** Width of the board, as a number of tiles */
    protected int width;

    /** Height of the board, as a number of tile */
    protected int height;

    /** Random source used to generate the board */
    protected static Random source = new Random();
}
