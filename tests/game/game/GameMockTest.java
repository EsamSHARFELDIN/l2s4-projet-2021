package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.exception.IllegalGameActionException;
import game.player.Player;
import game.player.WarPlayer;

public class GameMockTest {
    private Game g;
    private Player p1;
    private Player p2;

    @Before
    public void init() {
        this.g = new GameMock(12, 24);
        this.p1 = new WarPlayer("Samson");
        this.p2 = new WarPlayer("David");
    }

    @Test
    public void canConstructGame() {
        this.g = new GameMock(12, 24);
    }

    @Test
    public void canAddPlayer() {
        this.g.addPlayer(this.p1);
        this.g.addPlayer(this.p2);
        assertEquals(2, this.g.players.size());
        assertSame(this.p1, this.g.players.get(0));
        assertSame(this.p2, this.g.players.get(1));
    }

    @Test
    public void canRemovePlayerIfPlaying() throws IllegalGameActionException {
        this.g.addPlayer(this.p1);
        this.g.addPlayer(this.p2);
        assertEquals(2, this.g.players.size());
        assertSame(this.p1, this.g.players.get(0));
        assertSame(this.p2, this.g.players.get(1));
        this.g.removePlayer(this.p1);
        assertEquals(1, this.g.players.size());
        assertSame(this.p2, this.g.players.get(0));
    }

    @Test(expected = IllegalGameActionException.class)
    public void cannotRemovePlayerIfNotPlaying() throws IllegalGameActionException {
        this.g.addPlayer(this.p1);
        this.g.removePlayer(this.p2);
    }
}
