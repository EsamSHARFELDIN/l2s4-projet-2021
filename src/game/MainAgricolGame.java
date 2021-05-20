package game;

import game.game.Game;
import game.game.AgricolGame;
import game.exception.GameException;
import game.player.Player;
import game.player.AgricolPlayer;

/**
 * This is the main class of the agricol game.
 * To launch the agricol game, call the main() method.
 *
 */
public class MainAgricolGame {
    /**
     * @param args names of the players who are going
     * to play in this agricol game. Each element of this 
     * argument represents a player.
     * 
     */
    public static void main(String args[]) {
        Game game = new AgricolGame(10, 10);

        if (args.length == 0) {
            System.out.println("Usage: java game.MainAgricolGame %s [, ...]");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            Player p = new AgricolPlayer(args[i]);
            game.addPlayer(p);
        }

        Player winner = null;
        try {
            winner = game.play();
        }
        catch (GameException e) {
            e.printStackTrace();
        }

        System.out.println("Winner: " + winner.getName());
    }
}
