package game;

/**
 * A class which represents the action of not doing anything for a turn in a
 * board game. This class corresponds to a waiting turn, an can be extended in
 * cases where a wait has specific consequences.
 * @version 01/04/21
 */
public class DoNothingAction implements Action {
    /**
     * Construct an action corresponding to a waiting turn, with no consequences
     */
    public DoNothingAction() {}

    /**
     * @see Action#execute(Board, Player)
     * Execute a waiting action. Nothing happens, and arguments are only needed
     * for consistency reasons
     * @param board Playing board
     * @param player Player taking the action
     **/
    public void execute(Board board, Player player) {}
}
