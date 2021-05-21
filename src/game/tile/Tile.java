package game.tile;

import game.Resource;
import game.exception.IllegalGameActionException;
import game.unit.Unit;

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
     * Create a new tile
     * @param x Horizontal position on the board
     * @param y Vertical position on the board
     */
    public Tile(int x, int y) {
        this.unit = null;
        this.x = x;
        this.y = y;
    }

    /**
     * Return the horizontal coordinate of the tile
     *
     * @return Horizontal coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Return the vertical coordinate of the tile
     *
     * @return Vertical coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * This allows to know if a tile is busy or not.
     *
     * @return true if the tile is busy, otherwise false.
     */
    public boolean isBusy() {
        return (this.unit != null);
    }

    /**
     * Gives the ressource given by the tile.
     * @return Resource provided by the terrain of the tile
     * @throws IllegalGameActionException iff the tile does not produce a
     * resource
     */
    public abstract Resource getResource() throws IllegalGameActionException;

    /**
     * Gives the unit posted on the tile.
     *
     * @return The unit posted on the tile.
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * This allows to change the unit post on the tile. It does not imply that
     * the tile is also bound to the unit. You should call Unit::setTile for a
     * two way association
     *
     * @param u the unit that we want to post on the tile
     * @throws IllegalArgumentException when null is given as an argument.
     * @throws IllegalGameActionException if the set is forbidden (eg. on OceanTile)
     */
    public void setUnit(Unit u) throws IllegalArgumentException, IllegalGameActionException {
        if (u == null) {
            throw new IllegalArgumentException("Tried to set null as unit");
        }
        this.unit = u;
    }

    /**
     * Make sure that there is no unit placed in this tile after the call of this
     * method. Does not imply that the tile is unbound from the unit
     */
    public void unsetUnit() {
        this.unit = null;
    }

    /**
     * return the bonus gold a player may receive from each of his unit placed on
     * this type of tile when among the selectable actions he chooses to do nothing.
     *
     * <code>GOLD_WHEN_DOING_NOTHING</code> has to be initialized before running the
     * game (Game#play) to avoid undefined behavior.
     *
     * @return The bonus gold a player may receive from each of his unit placed on
     *         this type of tile when among the selectable actions he chooses to do
     *         nothing.
     */
    public abstract int getGoldWhenDoingNothing();

    /**
     * return The amounts of additional (bonus) power that an unit placed on this
     * type of tile may receives.
     *
     * @return The amounts of additional (bonus) power that an unit placed on this
     *         type of tile may receives.
     */
    public abstract int getAdditionnalPower();

    /**
     * return the bonus a player may receive from each of his unit placed on this
     * type of tile when counting the total points at the end of the game.
     *
     * @return The bonus a player may receive from each of his unit placed on this
     *         type of tile when counting the total points at the end of the game.
     */
    public abstract int getAdditionnalPoints();

    /**
     * Return the maximum army size allowed on a tile
     *
     * @return Maximum army size
     */
    public abstract int getMaxArmySize();

    /**
     * return the bonus to be added to the initial cost of an unit placed on this
     * tile.
     *
     * @return the bonus to be added to the initial cost of an unit placed on this
     *         tile.
     */
    public abstract int getCostAdd();

    /**
     * return the factor with which to multiply the initial cost of an unit placed
     * on this tile.
     *
     * @return the factor with which to multiply the initial cost of an unit placed
     *         on this tile.
     */
    public abstract int getCostFactor();

    /**
     * Print the tile to stdout, as part of the board representation
     */
    public void print() {
        if (this.unit != null) {
            this.unit.print();
        }
        else {
            System.out.print("      ");
        }
    }

    /**
     * Return a string representation of the tile
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
