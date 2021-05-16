package game.action;

import game.board.RandomBoard;
import game.player.Player;

/**
 * A class which represents the action of converting resources into gold in the
 * agricultural simulation game. When this action is executed, the resources
 * stored by the player are converted into gold, depending on rates defined
 * outside of this class
 * @version 01/04/21
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
    public void execute(RandomBoard board, Player player) {
        player.convertResource();
    }
}
