package game.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.exception.IllegalGameActionException;
import game.player.Player;
import game.player.WarPlayer;

public class GameMockTest {
    @Test
    public void canConstructGame() {
        GameMock g = new GameMock(24, 12);
    }

    @Test
    public void canAddPlayer() {
        GameMock g = new GameMock(24, 12);
        Player p = new WarPlayer("Claudius");
        g.addPlayer(p);
    }

    @Test
    public void canRemovePlayerIfPlaying() {
        GameMock g = new GameMock(24, 12);
        Player p = new WarPlayer("Claudius");
        g.addPlayer(p);
        g.removePlayer(p);
    }

    @Test(expected=IllegalGameActionException.class)
    public void cannotRemovePlayerIfNotPlaying() {
        GameMock g = new GameMock(24, 12);
        Player p1 = new WarPlayer("Claudius");
        Player p2 = new WarPlayer("Alphonse");
        g.addPlayer(p1);
        g.removePlayer(p2);
    }
}
