package game;

/**
 * A class to model the board in different games. A board is composed of tiles
 * of different types and is defined by a width and a height. A board is created
 * following two rules: at least 2 in 3 tiles are of type ocean, and all tile
 * that is not of type ocean must have a neighbouring tile which isn't either
 * @version 15/03/21
 */
public class Board {
    /**
     * Construct a board defined by its width (horizontal size) and a height
     * (vertical size), representing numbers of tiles
     * @param width Horizontal size in number of tiles
     * @param height Vertical size in number of tiles
     * @throws IllegalArgumentException iff either <code>width</code> or
     * <code>height</code> is negative
     */
    public Board(int width, int height) throws IllegalArgumentException;

    /**
     * Check whether the board is full, ie whether all of the occupable tiles
     * are currently occupied by units
     * @return <code>true</code> if all tiles are occupied, else
     * <code>false</code>*/
    public boolean isFull();

    /**
     * Return the tile located at the position of the board defined by the
     * coordinates passed as parameters
     * @param x Horizontal coordinate, should be an integer between
     * <code>0</code> and <code>width - 1</code>
     * @param y Vertical coordinate, should be an integer between
     * <code>0</code> and <code>height - 1</code>
     * @return The tile at the specified location
     * @throws UnknowTileException iff either <code>x</code> or <code>y</code>
     * is out of the specified bounds
     */
    public Tile tileAt(int x, int y) throws UnknownTileException; // TODO

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
        throws UnknownTileException,
        throws IllegalGameActionException; // TODO

    /**
     * Return the neighbouring tiles of the tile which occupies the specified
     * coordinates on the board as an array of tiles. The neighbouring tiles
     * occupy the position at the north, west, south and east of the specified
     * tile
     * @param x Horizontal coordinate, should be an integer between
     * <code>0</code> and <code>width - 1</code>
     * @param y Vertical coordinate, should be an integer between
     * <code>0</code> and <code>height - 1</code>
     * @return An array of tiles representing the neighbouring tiles. The array
     * may contain 2, 3 or 4 elements depending on the position of the initial
     * tile
     * @throws UnknownTileException iff either <code>x</code> or <code>y</code>
     * is out of the specified bounds
     */
    public Tile[] adjacentTiles(int x, int y) throws UnknowTileException; // TODO

    /** Two-dimensional array of tiles, used to represent the game world */
    protected Tile[][] tiles;

    /** Width of the board, as a number of tiles */
    protected int width;

    /** Height of the board, as a number of tile */
    protected int height;
}
