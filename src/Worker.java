/* Mes propositions d'ajout:
    GOLD_WHEN_PLAYER_DO_NOTHING static constant
*/

/**
 * this class modelize a worker. A worker is a type of unit used in the agricol game. Simply, the worker ... works.
 * This class extends the Unit class (@see Unit).
 * For further details @see "the original subject of the project, section 2."
 */
public class Worker {
    /**
     * create a worker with given place and player. Initially, a worker has 0 gold coin.
     * @param place place where this worker will be put on. Can be null iff this army is placed nowhere. 
     * @param player the player who control this army. Can be null iff this worker is not controled by a player.
     */
    public Worker(Tile place, Player player)  {

    }

    /**
     * gives the gold coin given by this worker when the player choose to do nothing (in the 1st step on the turn). 
     * It depends on this worker's place.
     * @see "original subjects section 3.2, règles complémentaires en fonction des territoires."
     * @return the gold coin given by this worker depending on this worker's place, when the player choose to do nothing.
     */
    public int goldCoinWhenPlayerDoesNothing() {
        return 0;
    }

    /**
     * gives the value of the remuneration (salary) this worker need to be kept after one turn.
     * @return the remuneration (salary) this worker need to be kept after one turn, it depends on 
     * the type of place it is set on (mountain, plain, forest, ...)
     */
    @Override
    public int cost() {
        return 0;
    }
}
