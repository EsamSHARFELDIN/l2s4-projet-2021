package game.action;

import game.board.Board;
import game.player.Player;

/**
 * A class which represents the action of not doing anything for a turn in a
 * board game. This class corresponds to a waiting turn, an can be extended in
 * cases where a wait has specific consequences.
 */
public class DoNothingAction implements Action {
    /**
     * Construct an action corresponding to a waiting turn, with no consequences
     */
    public DoNothingAction() {}

    /**
     * Execute a waiting action. Nothing happens, the arguments are only needed
     * for consistency reasons and are not modified. A trace is printed to
     * stdout
     *
     * @param board Playing board
     * @param player Player taking the action
     *
     * @see Action#execute(Board, Player)
     **/
    public void execute(Board board, Player player) {
        System.out.println(this.trace(player));
    }

    /**
     * Return a printable message representing the idling action
     * @param player Player choosing to idle
     * @return String representation of the action
     */
    private String trace(Player player) {
        return player + " idles";
    }
}
