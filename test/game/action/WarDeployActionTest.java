package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.game.Game;
import game.player.Player;
import game.player.WarPlayer;
import game.unit.Unit;
import game.unit.Worker;

public class WarDeployActionTest {
    @Test
    public void canConstruct() {
    	Unit u = new Worker();
        new WarDeployAction(0, 0, u);
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
