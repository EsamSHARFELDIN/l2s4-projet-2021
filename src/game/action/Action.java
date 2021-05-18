package game.action;

import game.board.Board;
import game.exception.GameException;
import game.player.Player;

/**
 * Interface representing an action in a board game. Classes implementing this
 * interface must provide a definition of the execute method, which can affect
 * the board or the player taking action. There is no guarantee that a
 * particular action is legal in a particular game, and execution of an illegal
 * action may throw a GameException
 */
public interface Action {
    /**
     * Execute this action with the given board and player
     * @param board The board on which the action is to be executed
     * @param player The player taking the action
     * @throws GameException if the action implies some illegal manipulation
     * of the board
     */
    void execute(Board board, Player player) throws GameException;
}
