package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Resource;
import game.action.Action;
import game.action.DoNothingAction;
import game.board.RandomBoard;
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
    
    Action a = new DoNothingAction();
    a.execute(b1, p2);

    assertEquals(1, p2.getResource(Resource.Stone));
    assertEquals(4, p2.getResource(Resource.Sand), 4);
    assertEquals(3, p2.getResource(Resource.Wheat), 3);
    assertEquals(2, p2.getResource(Resource.Wood), 2);
    assertEquals(15, p2.getGold());
  }
}
