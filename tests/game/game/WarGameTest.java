package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.exception.GameException;
import game.player.Player;
import game.player.WarPlayer;

public class WarGameTest {
    private WarGame g;
    private Player p1;
    private Player p2;
    private Player p3;

    @Before
    public void init() {
        this.g = new WarGame(20, 12);
        this.p1 = new WarPlayer("p1");
        this.p2 = new WarPlayer("p2");
        this.p3 = new WarPlayer("p3");
    }

    @Test
    public void canConstructGame() {
        this.g = new WarGame(20, 12);
        this.p1 = new WarPlayer("p1");
        this.p2 = new WarPlayer("p2");
        this.p3 = new WarPlayer("p3");
        this.g.addPlayer(p1);
        this.g.addPlayer(p2);
        this.g.addPlayer(p3);
    }

    @Test
    public void canPlay() throws GameException {
        this.g.addPlayer(p1);
        this.g.addPlayer(p2);
        this.g.addPlayer(p3);
        Player winner = this.g.play();
        assertTrue(winner == this.p1 || winner == this.p2 || winner == this.p3);
        for (Player p : g.players) {
            assertTrue(p.score() <= winner.score());
        }
        assertTrue(this.g.board.isFull() || this.g.turns_counter == 10);
    }
}
