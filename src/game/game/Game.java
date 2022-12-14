package game.game;
import java.util.LinkedList;
import java.util.List;

import game.board.Board;
import game.board.RandomBoard;
import game.exception.GameException;
import game.exception.IllegalGameActionException;
import game.player.Player;

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
     * @throws IllegalArgumentException iff width is less than 2 or height is less than 1
     */
    public Game(int width, int height) throws IllegalArgumentException {
    	this.board = new RandomBoard(width, height);
    	this.players = new LinkedList<Player>();
    }

    /**
     * adds a player.
     * @param p The player to add.
     */
    public void addPlayer(Player p) {
    	this.players.add(p);
    }

    /**
     * removes a player
     * @param p The player to remove.
     * @throws IllegalGameActionException iff the player is not playing
     */
    public void removePlayer(Player p) throws IllegalGameActionException {
    	if (! this.players.remove(p)) {
    		throw new IllegalGameActionException("Trying to remove a player that does"
    				+ "not belong to this game");
    	}
    }

    /**
     * Start the game and give the course of the game.
     * @return Player the winner of the game.
     * @throws GameException if any illegal behaviour is detected
     */
    public abstract Player play() throws GameException;

    /**
     * Makes sure the game is over.
     * @return True if the game is over, False otherwise.
     */
    protected abstract boolean isGameOver();

    /**
     * Return the player with the highest score in the list. It is assumed that
     * there is at least one player in the game
     * @return Winning player
     */
    protected Player findWinner() {
        Player winner = this.players.get(0);
        int maxScore = winner.score();
        for (Player player : this.players) {
            int currentScore = player.score();
            if (currentScore > maxScore) {
                winner = player;
                maxScore = currentScore;
            }
        }
        return winner;
    }
}
