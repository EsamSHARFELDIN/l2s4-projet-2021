package game.game;

import static org.junit.Assert.*;

import org.junit.Test;

import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;

public class AgricolGameTest {
    @Test
    public void canConstructGame() {
        AgricolGame g = new AgricolGame(20, 12);
        Player p1 = new AgricolPlayer("p1");
        Player p2 = new AgricolPlayer("p2");
        Player p3 = new AgricolPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
    }

    @Test
    public void canPlay() throws GameException {
        AgricolGame g = new AgricolGame(20, 12);
        Player p1 = new AgricolPlayer("p1");
        Player p2 = new AgricolPlayer("p2");
        Player p3 = new AgricolPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
        Player winner = g.play();
        assertTrue(winner == p1 || winner == p2 || winner == p3);
        for (Player p : g.players) {
            assertTrue(p.score() <= winner.score());
        }
        assertTrue(g.board.isFull() || g.turns_counter == 6);
    }
}
