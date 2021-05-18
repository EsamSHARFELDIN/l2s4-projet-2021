package game.action;

import game.board.Board;
import game.player.AgricolPlayer;
import game.player.Player;

/**
 * A class which represents the action of doing nothing and its consequences in
 * the agricultural simulation game. In this game, a players who decides to take
 * a waiting turn receives gold for each controlled tile, depending on the type
 * of terrain
 */
public class AgricolDoNothingAction extends DoNothingAction {
    /**
     * Construct a waiting action specific to the agricultural simulation game.
     * This action relies on the fact that the player taking the action is an
     * instance of the class AgricolPlayer
     */
    public AgricolDoNothingAction() {}

    /**
     * For every tiles he controls on the board through a unit, the player
     * receives the amount of gold contained in static variable
     * GOLD_WHEN_DOING_NOTHING in the corresponding tile class
     * @param board Playing board
     * @param player Player taking the action. Must be an instance of the
     * AgricolPlayer class
     *
     * @see DoNothingAction#execute(Board, Player)
     */
    public void execute(Board board, Player player) {
        super.execute(board, player);
        ((AgricolPlayer) player).collectIdleGold();

        System.out.println(this.trace(player));
    }

    /**
     * Return a printable message representing the idling action in the
     * agricultural simulation
     * @param player Player choosing to idle
     * @return String representation of the action
     */
    private String trace(Player player) {
        return player + " collects gold from their units";
    }
}
