package game;
/**
 * This class models a tile which is supposed to
 * be a desert area in the game with its
 * characteristics: dryness, little precipitation,
 * almost no plants nor animals, ... that may
 * imply something in the game proceeding.
 */
public class DesertTile extends Tile {

    /**
     * The cost of maintenance of an unit placed
     * on this type of tile.
     */
    public static int COST;

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
     * Create a desert type tile.
     */
    public DesertTile(int x, int y) {
        super(x, y);
    }

    /**
     * @see Tile#getResource()
     * Return the type of resource this area gives.
     * Desert area gives sands.
     *
     * @return the resource given by this tile which is
     * sand.
     */
    public Resource getResource() throws IllegalGameActionException {
        // TODO
        return Resource.Sand;
    }

    public void print() {
        System.out.print("D");
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
    public int getCost() {
    	return COST;
    }
}
