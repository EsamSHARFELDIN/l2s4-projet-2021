package game;

import game.game.*;
import game.exception.GameException;
import game.player.*;

public class MainAgricolGame {
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

        Player winner = null;;
        try {
            winner = game.play();
        }
        catch (GameException e) {
            e.printStackTrace();
        }

        System.out.println("Winner: " + winner.getName());
    }
}
