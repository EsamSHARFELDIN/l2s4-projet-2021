package game.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.board.Board;
import game.board.ExampleBoard;
import game.exception.GameException;
import game.exception.IllegalGameActionException;
import game.exception.UnknownTileException;
import game.player.AgricolPlayer;
import game.player.Player;
import game.tile.Tile;
import game.unit.Unit;
import game.unit.Worker;

public class DeployActionTest {
	
	private Board board;
	private Player p1;
	
	@Before
	public void setUp() {
		board = new ExampleBoard();
		p1 = new AgricolPlayer("Esam");
	}
 
    @Test
    public void canConstructTest() {
        Unit u1 = new Worker();
        Action a = new DeployAction(12, 10, u1);
    }

    @Test
    public void canExecuteAction() throws GameException {
        Board b1 = new ExampleBoard();
        

        /* Executer execute */
        Unit u1 = new Worker();
        Action a = new DeployAction(2, 3, u1);
        a.execute(b1, p1);
        assertSame(b1.tileAt(2, 3).getUnit(), u1);
    }
    
    @Test (expected=IllegalGameActionException.class)
    public void deployOnBusyTile() throws GameException {
    	Unit placeTaker = new Worker();
    	
    	Tile tile = board.tileAt(5, 0);
    	new DeployAction(tile.getX(), tile.getY(), placeTaker)
    	.execute(board, p1);
    	
    	assertTrue(tile.isBusy());
    	
    	// trying to deploy another unit on the same tile
    	// throws an exception
    	new DeployAction(tile.getX(), tile.getY(), new Worker())
    	.execute(board, p1);    	
    }
    
    @Test (expected=UnknownTileException.class)
    public void deployOnANonExistingTile() throws GameException {
    	// trying to deploy on a tile specified by out of bounds coordinates
    	new DeployAction(16, 24, new Worker())
    	.execute(board, p1); 
    }
}
