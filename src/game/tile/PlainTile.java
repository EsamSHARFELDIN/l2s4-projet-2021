package game.tile;

import game.Resource;
import game.exception.IllegalGameActionException;

/**
 * This class models a tile which is supposed to
 * be a plain area in the game with its
 * characteristics: green grasses, crops, some
 * farm animals, ... that may imply something
 * in the game proceeding.
 */
public class PlainTile extends Tile {

    /**
     * The max size allowed for an unit to be
     * placed on this type of tile.
     */
    public static int MAX_ARMY_SIZE;

    /**
     * The amounts of additional (bonus) power
     * that an unit placed on this type of tile
     * may receives.
     */
    public static int ADDITIONAL_POWER;

    /**
     * The bonus a player may receive from each of
     * his unit placed on this type of tile when
     * counting the total points at the end of the
     * game.
     */
    public static int ADDITIONAL_POINTS;

    /**
     * The bonus gold a player may receive from each of
     * his unit placed on this type of tile when among
     * the selectable actions he chooses to do nothing.
     */
    public static int GOLD_WHEN_DOING_NOTHING;

    /**
     * The bonus to be added to the initial cost
     * of an unit placed on this tile.
     */
    public static int COST_ADD;

    /**
     * the factor with which to multiply the
     * initial cost of an unit placed on this tile.s
     */
    public static int COST_FACTOR;

    /**
     * Create a plain type tile
     * @param x Horizontal position on the board
     * @param y Vertical position on the board
     */
    public PlainTile(int x, int y) {
        super(x, y);
    }

    /**
     * Return the type of resource this area gives.
     * Plain area gives wheat.
     *
     * @return the resource given by this tile which is
     * wheat.
     * @see Tile#getResource()
     */
    public Resource getResource() throws IllegalGameActionException {
        return Resource.Wheat;
    }

    /**
     * Print the tile to stdout, as part of the board representation
     */
    public void print() {
        System.out.print("P/");
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
        return GOLD_WHEN_DOING_NOTHING;
    }

    /**
     * {@inheritDoc}
     */
    public int getAdditionnalPower() {
        return ADDITIONAL_POWER;
    }

    /**
     * {@inheritDoc}
     */
    public int getAdditionnalPoints() {
        return ADDITIONAL_POINTS;
    }

    /** {@inheritDoc} */
    public int getMaxArmySize() {
        return MAX_ARMY_SIZE;
    }

    @Override
    public int getCostAdd() {
        return COST_ADD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCostFactor() {
        return COST_FACTOR;
    }

    /**
     * Return a string representation of the tile
     */
    public String toString() {
        return "Plain" + super.toString();
    }
}
