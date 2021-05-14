package game;

import game.player.Player;
import game.tile.Tile;

/** Mes propositions d'ajout:
 *	MAX_SIZE static constant
 *	MIN_SIZE static constant
 *	IllegalArgumentException in Army() when the given size is invalid
 */

/**
 * This class models an army. An army is a type of unit used in the war game. Simply, it works like ... an army.
 * This class extends the Unit class(@see Unit).
 * For further details @see the orginal subject of the project, section 2.
 *
 */
public class Army extends Unit {
	/**
	 * The maximum size an army can have.
	 */
	public static final int MAX_SIZE = 5;
	/**
	 * The minimum size an army can have.
	 */
	public static final int MIN_SIZE = 1;
	/**
	 * @param size the size of this army(from 1 to 5, included)
	 */
    protected int size;
    /**
     * create an army unit with given size, place and player.
     * @param place the place where to put this army. Can be null iff this army unit is placed nowhere.
     * @param player the player who control this army. Can be null iff this army is not controlled by a player.
     * @param size the size of this army (from 1 to 5, included).
     * @throws IllegalArgumentException when the given size is invalid.
     */
	public Army(Tile place, Player player, int size) throws IllegalArgumentException {
		super(place, player);
		if (size < getMinArmySize() || size > getMaxArmySize())
			throw new IllegalArgumentException("size need to be between (inclusive)"+ getMinArmySize() + "and "+ getMaxArmySize());
		this.size = size;
	}
	
	/**
	 * create an army with the given size. This army is not placed
	 * (yet) on any tile and does not belong (yet) to any player.
	 * @param size the size of this army (from 1 to 5, included).
	 * @throws IllegalArgumentException when the given size is invalid.
	 */
	public Army(int size) throws IllegalArgumentException { 
		this(null,  null, size);
	}
	
	/**
	 * create an army unit with given size and place. This army
	 * does not belong (yet) to any player.
	 * @param place the place where to put this army. Can be 
	 * null iff this army unit is placed nowhere.
	 * @param size the size of this army (from 1 to 5, included).
	 * @throws IllegalArgumentException when the given size is invalid.
	 */
	public Army(Tile place, int size) throws IllegalArgumentException {
		this(place, null, size);
	}
	
	/**
	 * gives the size of this army
	 * @return the size of this army
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * increase by <code>incr</code> this army's size. The latter cannot exceed MAX_SIZE (default: 5)
	 * @param incr the value with which the size's increment is done.
	 */
	public void incrementSize(int incr) {
		this.size = Math.max(this.size + incr, MAX_SIZE);
	}
	
	/**
	 * decrease by <code>decr</code> this army's size. The latter cannot exceed MIN_SIZE (default: 1)
     * @param decr the value with which the size's decrement is done.
	 */
	public void decrementSize(int decr) {
		this.size = Math.min(this.size - decr, MIN_SIZE);
	}
	
	/**
     * gives the military (relative) strength of this army from the point of view of the enemy and 
     * depending on this army's type of place (mountain, desert, forest, ...)
     * @return the military (relative) strength of this army.
     */
	public int militaryStrength() {
		return getSize() + this.tile.getAdditionnalPower(); 
	}
	/**
     * gives the value of quantity of food this army needs to be kept after one turn.
     * @return the quantity of food this army needs to be kept after one turn.
     */
	@Override
	public int cost() {
		return this.size * this.tile.getCostFactor();
	}
	/**
	 * gives the bonus points given by this army depending on the type of place it's set on (mountain, desert, plain, ...).
	 * For more details, @see the original subject of the project, section 2.2.2
	 * @see Unit#points
	 * @return the bonus point given by this army depending on the type of place it's set on (mountain, desert, plain, ...).
	 */
	@Override
	public int points() {
		return this.tile.getAdditionnalPoints();
	}    
	
	/**
	 * @return the max size of unit allowed on this tile.
	 */
	private int getMaxArmySize() {
		if (this.hasTile()) {
			return this.getTile().getMaxArmySize();
		}
		else {
			return Army.MAX_SIZE;
		}
	}
	
	/**
	 * @return the minimum size of unit allowed on this tile.
	 */
	private int getMinArmySize() {
		return Army.MIN_SIZE;
	}
}