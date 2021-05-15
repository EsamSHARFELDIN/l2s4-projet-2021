package game.action;

import game.Board;
import game.player.AgricolPlayer;
import game.player.Player;

/**
 * A class which represents the action of doing nothing and its consequences in
 * the agricultural simulation game. In this game, a players who decides to take
 * a waiting turn receives gold for each controlled tile, depending on the type
 * of terrain
 * @version 01/04/21
 */
public class AgricolDoNothingAction extends DoNothingAction {
    /**
     * Construct a waiting action specific to the agricultural simulation game
     */
    public AgricolDoNothingAction() {}

    /**
     * @see DoNothingAction#execute(Board, Player)
     * Execute the action: the player receives a gold coin for each Plain or
     * Forest he controls, and two coins for each Desert
     * @param board Playing board
     * @param player Player taking the action
     */
    public void execute(Board board, Player player) {
        /* TODO talk about the downcast */
        ((AgricolPlayer) player).collectIdleGold();
    }
}