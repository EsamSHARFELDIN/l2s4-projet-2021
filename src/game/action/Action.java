package game.action;

import game.board.Board;
import game.exception.GameException;
import game.player.Player;

/**
 * This class represents an action.
 * More precisely,  it is an action among those the player 
 * can choose each first part of the game.
 * For example, in the War game, a player, in the first part of his turn,
 * can choose between deploying and doing nothing.
 * An action can be executed (realized).
 *
 */
public interface Action {
	/**
	 * Realize this action with the given board and player.
	 * 
	 * @param board the board with which the action will be realized.
	 * @param player the player that is realizing this action.
	 */
    void execute(Board board, Player player) throws GameException;
}