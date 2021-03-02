package game;

/**
 * this class modelize a worker. A worker is a type of unit used in the agricol game. Simply, the worker .... works.
 * this class extends the Unit class (@see Unit).
 * for further details @see "the original subjest of the project, section 2."
 *
 */
public class Worker extends Unit{
	/**
	 * create a worker with given place and player. initially, a worker has 0 gold coin.
	 * 
	 * @param place place where this worker will be put on. can be null iff this army is placed nowhere. 
	 * @param player the player who control this army. Can be null iff this worker is not controlled by a player
	 */

	public Worker(Tile place, Player player) {
		super(place, player);
		this.place = place;
		this.player = player;
	}
	/**
	 * gives the gold coin given by this worker when the player choose to do nothing (in the 1st step on the turn).
	 * It depends on this worker's place.
	 * @see "Original subjects section 3.2, régles complémentaires en fonction des territoires."
	 * @return the gold coin given by this worker depending on this worker's place, when the player choose to do nothng.
	 */
	public int goldcoinWhenplayerDoesNothing() {
		
		return 0;
		
		
	}
	/**
	 * gives the value of the remuneration (salary) this worker need to be kept after one turn.
	 * @return the remuneration (salary) this worker need to be kept after one turn, it depends on the type of place it is 
	 * set on (mountain, plain, forest, ...)
	 */
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
    
	
}