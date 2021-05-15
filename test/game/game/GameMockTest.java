package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.exception.IllegalGameActionException;
import game.player.Player;
import game.player.WarPlayer;

public class GameMockTest {
    private Game g;

    @Before
    public void init() {
        this.g = new GameMock(12, 24);
    }

    @Test
    public void canConstructGame() {
        this.g = new GameMock(12, 24);
    }

    @Test
    public void canAddPlayer() {
        Player p1 = new WarPlayer("Samson");
        Player p2 = new WarPlayer("David");
        this.g.addPlayer(p1);
        this.g.addPlayer(p2);
        assertEquals(2, this.g.players.size());
        assertSame(p1, this.g.players.get(0));
        assertSame(p2, this.g.players.get(1));
    }

    @Test
    public void canRemovePlayerIfPlaying() throws IllegalGameActionException {
        Player p1 = new WarPlayer("Samson");
        Player p2 = new WarPlayer("David");
        this.g.addPlayer(p1);
        this.g.addPlayer(p2);
        assertEquals(2, this.g.players.size());
        assertSame(p1, this.g.players.get(0));
        assertSame(p2, this.g.players.get(1));
        this.g.removePlayer(p1);
        assertEquals(1, this.g.players.size());
        assertSame(p2, this.g.players.get(0));
    }

    @Test(expected = IllegalGameActionException.class)
    public void cannotRemovePlayerIfNotPlaying() throws IllegalGameActionException {
        Player p1 = new WarPlayer("Samson");
        Player p2 = new WarPlayer("David");
        this.g.addPlayer(p1);
        this.g.removePlayer(p2);
    }
}
