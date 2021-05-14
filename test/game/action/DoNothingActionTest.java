package game.action;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Player;
import game.Resource;
import game.action.Action;
import game.action.DoNothingAction;

public class DoNothingActionTest {

  @Test 
    public void canConstructorTest() {
      Action a = new DoNothingAction();
    }

  @Test
  public void canExecuteTest() {

    Board b1 = new Board(15, 10);
    Player p1 = new Player("Esam", 1, 4, 3, 2, 0);
    Action a = new DoNothingAction();
    a.execute(b1, p2);

    assertEquals(p2.getResource(Resource.Stone), 1);
    assertEquals(p2.getResource(Resource.Sand), 4);
    assertEquals(p2.getResource(Resource.Wheat), 3);
    assertEquals(p2.getResource(Resource.Wood), 2);
    assertEquals(p2.getGold(), 0);
  }

}