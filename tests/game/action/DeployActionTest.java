package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.action.Action;
import game.action.DeployAction;
import game.board.Board;
import game.board.ExampleBoard;
import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;
import game.unit.Unit;
import game.unit.Worker;

public class DeployActionTest {

    @Test
    public void canConstructTest() {
        Unit u1 = new Worker();
        Action a = new DeployAction(12, 10, u1);
    }

    @Test
    public void canExecuteAction() throws GameException {
        Board b1 = new ExampleBoard();
        Player p1 = new AgricolPlayer("Esam");

        /* Executer execute */
        Unit u1 = new Worker();
        Action a = new DeployAction(2, 3, u1);
        a.execute(b1, p1);
        assertSame(b1.tileAt(2, 3).getUnit(), u1);
    }
}
