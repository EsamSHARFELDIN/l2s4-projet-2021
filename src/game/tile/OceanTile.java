package game.tile;

import game.Resource;
import game.exception.IllegalGameActionException;
import game.unit.Unit;

/**
 * This class models a tile which is supposed to
 * be a ocean area in the game with its
 * characteristics: a deep blue ocean ... that
 * may imply something in the game proceeding.
 */
public class OceanTile extends Tile {

    /**
     * Create an ocean type tile.
     * @param x Horizontal position on the board
     * @param y Vertical position on the board
     */
    public OceanTile(int x, int y) {
        super(x, y);
    }

    /**
     * Exceptionally, this area does not give any resource.
     * @return it's supposed to return nothing but only
     * throws an exception.
     * @throws IllegalGameActionException this method always
     * throws this exception because it's supposed to not give
     * any resources.
     * @see Tile#getResource()
     */
    public Resource getResource() throws IllegalGameActionException {
        throw new IllegalGameActionException("Trying to get resources from "
                                             + "an ocean tile");
    }

    /**
     * Since no unit can be placed in this tile, it's always busy.
     * @return always <code>true</code>.
     * @see Tile#isBusy()
     */
    public boolean isBusy() {
        return true;
    }

    /**
     * Since unit can't be placed on ocean tile, this
     * method always throws an exception
     *
     * @param u the unit that is supposed to be placed.
     * @throws IllegalGameActionException Since unit
     * can't be placed on ocean tile, this method always
     * throws an exception.
     * @see Tile#setUnit(Unit)
     */
    public void setUnit(Unit u) throws IllegalGameActionException {
        throw new IllegalGameActionException("Trying to set an unit on an"
                                             + "ocean tile");
    }

    /**
     * Print the tile to stdout, as part of the board representation
     */
    public void print() {
        System.out.print("O/");
        super.print();
    }

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
    public int getGoldWhenDoingNothing() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getAdditionnalPower() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int getAdditionnalPoints() {
        return 0;
    }

    /** {@inheritDoc} */
    public int getMaxArmySize() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCostAdd() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCostFactor() {
        return 0;
    }

    /**
     * Return a string representation of the tile
     */
    public String toString() {
        return "Ocean" + super.toString();
    }
}
