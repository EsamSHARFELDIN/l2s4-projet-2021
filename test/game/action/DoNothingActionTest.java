package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Resource;
import game.action.Action;
import game.action.DoNothingAction;
import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;
import game.unit.Army;

public class DoNothingActionTest {

  @Test 
    public void canConstruct() {
      Action a = new DoNothingAction();
    }

  @Test
  public void canExecute() throws GameException {

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
    
    Action a = new DoNothingAction();
    a.execute(b1, p2);

    assertEquals(p2.getResource(Resource.Stone), 1);
    assertEquals(p2.getResource(Resource.Sand), 4);
    assertEquals(p2.getResource(Resource.Wheat), 3);
    assertEquals(p2.getResource(Resource.Wood), 2);
    assertEquals(p2.getGold(), 0);
  }
}