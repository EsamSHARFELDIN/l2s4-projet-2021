package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.GameException;
import game.action.Action;
import game.action.DeployAction;
import game.player.Player;
import game.unit.Unit;

public class DeployActionTest {
    
    @Test
    public void canConstructorTest() {
    Unit u1 = new Unit();
    Action a = new DeployAction(12, 10, u1);
    }
        
    @Test (expected = GameException.class)
    public void canExecuteAction() {
    Board b1 = new Board(15, 10);
    Player p1 = new Player("Esam", 0, 0, 0, 0, 0);
    /* Executer execute */
    Action a = new DeployAction(12, 10, u1);
    a.execute(b1, p1);
    assertSame(b1.tilesAt(12, 10).getUnit(), u1);
    }
}
