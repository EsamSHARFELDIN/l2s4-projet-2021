package game;

/**
 * A class which represents the action of doing nothing and its consequences in
 * the agricultural simulation game. In this game, a players who decides to take
 * a waiting turn receives gold for each controlled tile, depending on the type
 * of terrain
 */
public class AgricolDoNothingAction extends DoNothingAction {
    /**
     * Construct a waiting action specific to the agricultural simulation game
     */
    public AgricolDoNothingAction() {
        // TODO
    }

    /**
     * @see DoNothingAction#execute(Board, Player)
     * Execute the action: the player receives a gold coin for each Plain or
     * Forest he controls, and two coins for each Desert
     * @param board Playing board
     * @param player Player who is deploying the unit
     */
    public void execute(Board board, Player player) {
        // TODO
    }
}
