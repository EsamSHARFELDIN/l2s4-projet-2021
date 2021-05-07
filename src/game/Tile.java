package game;
import game.Resource;
import game.Unit;

/**
 * This class is use to represents the Tile of the board.
 */

public abstract class Tile {
    /** Unit occupying the tile */
    protected Unit unit;

    /** Horizontal coordinate of the tile */
    protected int x;

    /** Vertical coordinate of the tile */
    protected int y;

    /**
     * Creates a new tile.
     */
    public Tile(int x, int y) {
        this.unit = null;
        this.x = x;
        this.y = y;
    }

    /**
     * Return the horizontal coordinate of the tile
     * @return Horizontal coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Return the vertical coordinate of the tile
     * @return Vertical coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * This allows to know if a tile is busy or not.
     * @return true if the tile is busy, otherwise false.
     */
    public boolean isBusy() {
        return true;
    }

    /**
     * Gives the ressource given by the tile.
     */
    public abstract Resource getResource() throws IllegalGameActionException;

    /**
     * Gives the unit posted on the tile.
     * @return The unit posted on the tile.
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * This allows to change the unit post on the tile.
     * @param u the unit that we want to post on the tile
     * @throws IllegalArgumentException when null is given as
     * an argument.
     */
    public void setUnit(Unit u) throws IllegalArgumentException, IllegalGameActionException {

    }

    /**
     * Make sure that there is no unit placed in this tile
     * after the call of this method.
     */
    public void unsetUnit() {
        //TODO
    }
    
    /**
     * return the cost of maintenance of an unit placed
     * on this type of tile.
     * 
     * <code>COST</code> has to be 
     * initialized before running the game (Game#play) 
     * to avoid undefined behavior.
     * 
     * @return the cost of maintenance of an unit placed
     * on this type of tile.
     */
    public abstract int getCost();
    
    /**
     * return the bonus gold a player may receive from each of
     * his unit placed on this type of tile when among
     * the selectable actions he chooses to do nothing.
     * 
     * <code>GOLD_WHEN_DOING_NOTHING</code> has to be 
     * initialized before running the game (Game#play) 
     * to avoid undefined behavior.
     * 
     * @return The bonus gold a player may receive from each of
     * his unit placed on this type of tile when among
     * the selectable actions he chooses to do nothing.
     */
    public abstract int getGoldWhenDoingNothing();

    public abstract void print();
}
