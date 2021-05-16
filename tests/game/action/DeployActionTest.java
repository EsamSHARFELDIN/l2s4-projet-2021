package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.action.Action;
import game.action.DeployAction;
import game.board.RandomBoard;
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
    public void canExecuteAction() throws GameException{
	    RandomBoard b1 = new RandomBoard(15, 10);
	    Player p1 = new AgricolPlayer("Esam");
	    
	    /* Executer execute */
	    Unit u1 = new Worker();
	    Action a = new DeployAction(12, 10, u1);
	    a.execute(b1, p1);
	    assertSame(b1.tileAt(12, 10).getUnit(), u1);
    }
}
