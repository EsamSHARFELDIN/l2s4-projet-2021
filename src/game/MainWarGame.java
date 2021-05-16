package game;

import game.game.Game;
import game.game.WarGame;
import game.exception.GameException;
import game.player.Player;
import game.player.WarPlayer;

public class MainWarGame {
    public static void main(String args[]) {
        Game game = new WarGame(10, 10);

        if (args.length == 0) {
            System.out.println("Usage: java game.MainWarGame %s [, ...]");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            Player p = new WarPlayer(args[i]);
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
