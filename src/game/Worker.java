package game;

import game.player.Player;

/**
 * this class models a worker. A worker is a type of unit used in the agricultural ("agricol") game. 
 * Simply, the worker .... works.
 * this class extends the Unit class (@see Unit).
 * for further details @see "the original subjest of the project, section 2."
 *
 */
public class Worker extends Unit {
	/**
	 * the gold quantity a worker initially have just after creation
	 */
	public static final int INITIAL_GOLD_QUANTITY = 0;
	/**
	 * create a worker with given place and player. initially, a worker has 0 gold coin.
	 * 
	 * @param place place where this worker will be put on. can be null iff this army is placed nowhere. 
	 * @param player the player who control this army. Can be null iff this worker is not controlled by a player
	 */
	public Worker(Tile place, Player player) {
		super(place, player);
		this.goldQuantity = INITIAL_GOLD_QUANTITY;
	}
	
	/**
	 * create a worker which is not placed (yet) on any tile
	 * and does not belong (yet) to any player.
	 */
	public Worker() {
		this(null, null);
	}
	
	/**
	 * create a worker with the given place.
	 * @param place place where this worker will be put on. 
	 * Can be null iff this army is placed nowhere.
	 */
	public Worker(Tile place) {
		this(place, null);
	}
	
	/**
	 * gives the gold coin given by this worker when the player choose to do nothing (in the 1st step on the turn).
	 * It depends on this worker's place.
	 * @see "Original subjects section 3.2, régles complémentaires en fonction des territoires."
	 * @return the gold coin given by this worker depending on this worker's place, when the player choose to do nothng.
	 */
	public int goldcoinWhenplayerDoesNothing() {
		return this.tile.getGoldWhenDoingNothing();		
	}
	
	/**
	 * gives the value of the remuneration (salary) this worker need to be kept after one turn.
	 * @return the remuneration (salary) this worker need to be kept after one turn, it depends on the type of place it is 
	 * set on (mountain, plain, forest, ...)
	 * @see "Original subjects section 3.2, régles complémentaires en fonction des territoires."
	 */
	@Override
	public int cost() {
		// we can consider that the initial cost here is 0
		return this.tile.getCostAdd();
	}	
}