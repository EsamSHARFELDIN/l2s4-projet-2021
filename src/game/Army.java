package game;

/** Mes propositions d'ajout:
 *	MAX_SIZE static constant
 *	MIN_SIZE static constant
 *	IllegalArgumentException in Army() when the given size is invalid
 */

/**
 * This class modelize an army. An army is a type of unit used in the war game. Simply, it works like ... an army.
 * This class extends the Unit class(@see Unit).
 * For futher details @see the orginal subject of the project, section 2.
 *
 */
public class Army extends Unit {
	/**
	 * @param size the size of this army(from 1 to 5, included)
	 */
    protected int size;
    /**
     * create an army unit with given size, place and player.
     * @param place the place where to put this army. Can be null iff this army unit is placed nowhere.
     * @param player the player who control this army. Can be null iff this army is not controled by a player.
     * @param size the size of this army (from 1 to 5, included).
     * @throws Exception when the given size is invalid.
     */
	public Army(Tile place, Player player, int size) throws IllegalArgumentException{
		super(place, player);
		this.size = size;
	}
	
	/**
	 * gives the size of this army
	 * @return the size of this army
	 */
	public int getSize() {
		return 0;
	}
	
	/**
	 * increase by <code>incr</code> this army's size. The latter cannot exceed MAX_SIZE (default: 5)
	 * @param incr the value with which the size's incrementation is done.
	 */
	public void incrementSize(int incr) {
		
	}
	
	/**
	 * decrease by <code>decr</code> this army's size. The latter cannot exceed MIN_SIZE (default: 1)
     * @param decr the value with which the size's decrementation is done.
	 */
	public void decrementSize(int decr) {
		
	}
	
	/**
     * gives the military (relative) strength of this army from the point of view of the ennemy and 
     * depending on this army's type of place (mountain, desert, forest, ...)
     * @return the military (relative) strength of this army.
     */
	public int militaryStrength() {
		return 0;
	}
	
	 /**
	 * gives the bonus points given by this army depending on the type of place it's set on (mountain, desert, plain, ...).
	 * For more details, @see the original subject of the project, section 2.2.2
	 * @see Unit#points
	 * @return the bonus point given by this army depending on the type of place it's set on (mountain, desert, plain, ...).
	 */

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return super.cost();
	}
	 /**
     * gives the value of quantity of food this army needs to be kept after one turn.
     * @return the quantity of food this army needs to be kept after one turn (it's equivalent to its size (@see #getSize())).
     */

	@Override
	public int points() {
		// TODO Auto-generated method stub
		return super.points();
	}
	
    
}