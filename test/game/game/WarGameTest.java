package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Player;
import game.WarPlayer;

public class WarGameTest {
    @Test
    public void canConstructGame() {
        Game g = new Wargame(20, 12);
        Player p1 = new WarPlayer("p1");
        Player p2 = new WarPlayer("p2");
        Player p3 = new WarPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
    }

    @Test
    public void canPlay() {
        Game g = new Wargame(20, 12);
        Player p1 = new WarPlayer("p1");
        Player p2 = new WarPlayer("p2");
        Player p3 = new WarPlayer("p3");
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);
        Player winner = g.play();
        assertTrue(winner == p1 || winner == p2 || winner == p3);
    }
}
