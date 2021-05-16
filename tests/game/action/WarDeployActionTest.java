package game.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.board.RandomBoard;
import game.exception.GameException;
import game.exception.UnknownTileException;
import game.game.Game;
import game.player.Player;
import game.player.WarPlayer;
import game.tile.OceanTile;
import game.tile.Tile;
import game.unit.Army;
import game.unit.Unit;
import game.unit.Worker;

public class WarDeployActionTest {
	private RandomBoard b;
	private Army unitToDeploy;
	private Player p1;
	/**
	 * Enemy player
	 */
	private Player p2;
	
	@Before
	public void setUp() {
		b = new RandomBoard(10, 10);
		unitToDeploy = new Army(0);
	}
    @Test
    public void canConstruct() {
    	Unit u = new Worker();
        new WarDeployAction(0, 0, u);
        p1 = new WarPlayer("Gentil");
        p2 = new WarPlayer("Méchant");
    }
    
    /**
     * @param b a board well constructed
     * @return a tile from <code>b</code> which is not
     * an OceanTile
     */
    static private Tile findNotOceanTile(RandomBoard b) {
    	for (int x = 0; x < b.getWidth(); x++) {
    		for (int y = 0; y < b.getHeight(); y++) {
    			Tile current = null;
    			try {
    				current = b.tileAt(x, y);
    			}
    			catch (UnknownTileException e) {
    				// nothing
    			}
    			if (!(current instanceof OceanTile)) {
    				return current;
    			}
    		}
    	}
    	return null;
    }

    
	/*
	 * When the enemy's military strength is less than the deployed
	 * army's military strength
	 */
	@Test
	public void deployWithInferiorEnnemyBeside() throws GameException {
	   /* 
	    * enemy's military strength can't be greater than 
		* unitToDeploy's military strength even if enemy is on a mountain
		*/
	   int initialSize = 2;
	   Army enemy = new Army(initialSize);
	   unitToDeploy = new Army(5);
	   Tile tileForEnemy = findNotOceanTile(b);
	   
	   
	   new WarDeployAction(tileForEnemy.getX(), tileForEnemy.getY(), enemy)
	   		.execute(b, p2);
	   
	   Tile tileForAlly = b.adjacentTiles(tileForEnemy.getX(), tileForEnemy.getY())
			   				.get(0);
	   new WarDeployAction(tileForAlly.getX(), tileForAlly.getY(), unitToDeploy)
	   		.execute(b, p1);
	   
	   // enemy's size should be halved
	   assertSame(initialSize / 2, enemy.getSize());
	}
	
	/*
	 * When the enemys's military strength is less than the deployed
	 * ally army's military strength and also less or equal than 1.
	 */
	@Test
	public void deployWithCapture() {
		Army enemy = new Army(1);
		unitToDeploy = new Army(3);
		Tile tileForEnemy = b.tileAt(1, 1) // A mountain tile
		int initialGold = p1.getGold();
		
		new WarDeployAction(tileForEnemy.getX(), tileForEnemy.getY(), enemy)
   		.execute(b, p2);
		
		Tile tileForAlly = b.tileAt(2, 1);
		
		new WarDeployAction(tileForAlly.getX(), tileForAlly.getY(), unitToDeploy)
   		.execute(b, p1);
		
		// the enemy should be captured by p1
		assertTrue(p1.hasUnit(enemy));
		
		// p1 receive 2 gold
		assertSame(initialGold + 2, p1.getGold());
	}
}
