package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.AgricolPlayer;
import game.Player;
import game.game.Game;

public class AgricolGameTest {
    @Test
    public void canConstructGame() {
        Game g = new Agricolgame(20, 12);
        Player p1 = new AgricolPlayer("p1");
        Player p2 = new AgricolPlayer("p2");
        Player p3 = new AgricolPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
    }

    @Test
    public void canPlay() {
        Game g = new Agricolgame(20, 12);
        Player p1 = new AgricolPlayer("p1");
        Player p2 = new AgricolPlayer("p2");
        Player p3 = new AgricolPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
        Player winner = g.play();
        assertTrue(winner == p1 || winner == p2 || winner == p3);
    }
}
