package game.action;

import game.board.Board;
import game.player.Player;

/**
 * A class which represents the action of converting resources into gold in the
 * agricultural simulation game. When this action is executed, the resources
 * stored by the player are converted into gold, depending on rates defined
 * outside of this class
 */
public class AgricolExchangeAction implements Action {
    /**
     * Construct a conversion action specific to the agricultural simulation game
     */
    public AgricolExchangeAction() {}

    /**
     * Execute the action: resources stored by the player are converted into
     * gold. The rates should be as follows : Stone = 8 gold coins, Sand = 5
     * coins, Wood = Wheat = 2 coins
     * @param board Playing board
     * @param player Player who is deploying the unit
     */
    public void execute(Board board, Player player) {
        System.out.println(this.trace(player));
        player.convertResource();
    }

    /**
     * Return a printable message representing the exchange action in the
     * agricultural simulation
     * @param player Player choosing to exchange their resources
     * @return String representation of the action
     */
    private String trace(Player player) {
        return player + " exchanges their resources";
    }
}
