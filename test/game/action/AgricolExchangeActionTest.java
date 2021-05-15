package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Resource;
import game.action.Action;
import game.action.AgricolExchangeAction;
import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;

public class AgricolExchangeActionTest {
    
    @Test 
    public void canConstructorTest() {
      Action a = new AgricolExchangeAction();
    }

    @Test
    public void canExecuteTestWithoutResources() throws GameException {
      Action a = new AgricolExchangeAction();
      Board b1 = new Board(15, 10);
      
      Player p1 = new AgricolPlayer("Kilian");
      
      a.execute(b1, p1);
      assertEquals(p1.getResource(Resource.Stone), 0);
      assertEquals(p1.getResource(Resource.Sand), 0);
      assertEquals(p1.getResource(Resource.Wheat), 0);
      assertEquals(p1.getResource(Resource.Wood), 0);
      assertEquals(p1.getGold(), 0);
    }

    @Test
    public void canExecuteTestWithResources() throws GameException {
      Action a = new AgricolExchangeAction();
      Board b1 = new Board(15, 10);

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
      assertEquals(p2.getResource(Resource.Stone), 0);
      assertEquals(p2.getResource(Resource.Sand), 0);
      assertEquals(p2.getResource(Resource.Wheat), 0);
      assertEquals(p2.getResource(Resource.Wood), 0);
      assertEquals(p2.getGold(), 38);
    }
}

