/**
 * 
 */
package game;

/**
 * This class models a tile which is supposed to
 * be a mountain area in the game with its 
 * characteristics: altitude, difficult access, 
 * great view ... that may imply something in the 
 * game proceeding.
 */
public class MountainTile extends Tile {
	
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
	 * create a mountain type tile.
	 */
	public MountainTile() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see Tile#getResource()
	 * Return the type of resource this area gives.
	 * Mountain area gives rocks.
	 * 
	 * @return the resource given by this tile which is
	 * rock.
	 */
	public Resource getResource() {
		//TODO
		return null;
	}

}
