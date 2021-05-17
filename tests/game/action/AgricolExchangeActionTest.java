package game.action;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import game.Resource;
import game.action.Action;
import game.action.AgricolExchangeAction;
import game.board.RandomBoard;
import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;
import game.tile.*;

public class AgricolExchangeActionTest {
    @BeforeClass
    public static void setAgricolGameContext() {
        Resource.setConversionValue(Resource.Stone, 8);
        Resource.setConversionValue(Resource.Sand, 5);
        Resource.setConversionValue(Resource.Wood, 2);
        Resource.setConversionValue(Resource.Wheat, 2);

        PlainTile.MAX_ARMY_SIZE = 1;
        PlainTile.ADDITIONAL_POWER = 0;
        PlainTile.ADDITIONAL_POINTS = 0;
        PlainTile.GOLD_WHEN_DOING_NOTHING = 1;
        PlainTile.COST_ADD = 1;
        PlainTile.COST_FACTOR = 1;

        MountainTile.MAX_ARMY_SIZE = 1;
        MountainTile.ADDITIONAL_POWER = 0;
        MountainTile.ADDITIONAL_POINTS = 0;
        MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
        MountainTile.COST_ADD = 5;
        MountainTile.COST_FACTOR = 1;

        ForestTile.MAX_ARMY_SIZE = 1;
        ForestTile.ADDITIONAL_POWER = 0;
        ForestTile.ADDITIONAL_POINTS = 0;
        ForestTile.GOLD_WHEN_DOING_NOTHING = 1;
        ForestTile.COST_ADD = 1;
        ForestTile.COST_FACTOR = 1;

        DesertTile.MAX_ARMY_SIZE = 1;
        DesertTile.ADDITIONAL_POWER = 0;
        DesertTile.ADDITIONAL_POINTS = 0;
        DesertTile.GOLD_WHEN_DOING_NOTHING = 2;
        DesertTile.COST_ADD = 3;
        DesertTile.COST_FACTOR = 1;
    }
    
    @Test 
    public void canConstructorTest() {
      Action a = new AgricolExchangeAction();
    }

    @Test
    public void canExecuteTestWithoutResources() throws GameException {
      Action a = new AgricolExchangeAction();
      RandomBoard b1 = new RandomBoard(15, 10);
      
      Player p1 = new AgricolPlayer("Kilian");
      
      a.execute(b1, p1);
      assertEquals(0, p1.getResource(Resource.Stone));
      assertEquals(0, p1.getResource(Resource.Sand));
      assertEquals(0, p1.getResource(Resource.Wheat));
      assertEquals(0, p1.getResource(Resource.Wood));
      assertEquals(15, p1.getGold());
    }

    @Test
    public void canExecuteTestWithResources() throws GameException {
      Action a = new AgricolExchangeAction();
      RandomBoard b1 = new RandomBoard(15, 10);

      int stoneStock = 1;
      int sandStock = 4;
      int wheatStock = 3;
      int woodStock = 2;
      
      Player p2 = new AgricolPlayer("Esam");
      p2.incrementResource(stoneStock, Resource.Stone);
      p2.incrementResource(sandStock, Resource.Sand);
      p2.incrementResource(wheatStock, Resource.Wheat);
      p2.incrementResource(woodStock, Resource.Wood);

      a.execute(b1, p2);
      assertEquals(0, p2.getResource(Resource.Stone));
      assertEquals(0, p2.getResource(Resource.Sand));
      assertEquals(0, p2.getResource(Resource.Wheat));
      assertEquals(0, p2.getResource(Resource.Wood));
      assertEquals(53, p2.getGold());
    }
}

