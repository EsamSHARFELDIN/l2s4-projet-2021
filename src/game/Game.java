package game;
import game.Board;
import game.Player;

/**
 * An abstract class which allows to model the game.
 */

public abstract class Game {
    protected Board board;
    protected List<Player> players;

    /**
     * Creates a game with a board of given dimensions and an empty list
     * of players
     * @param width Width of the board to use
     * @param height Height of the board to use
     */
    public Game(int width, int height) {

    }

    /**
     * adds a player.
     * @param p The player to add.
     */
    public void addPlayer(Player p) {

    }

    /**
     * removes a player
     * @param p The player to remove.
     * @throws IllegalGameActionException iff the player is not playing
     */
    public void removePlayer(Player p) throws IllegalGameActionException {

    }

    /**
     * Start the game and give the course of the game.
     * @return Player the winner of the game.
     */
    public abstract Player play() {

    }

    /**
     * Makes sure the game is over.
     * @return True if the game is over, False otherwise.
     */
    private boolean isGameOver() {

    }
}
