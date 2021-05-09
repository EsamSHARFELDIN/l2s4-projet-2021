package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgricolExchangeActionTest {
    
    @Test 
    public void canConstructorTest() {
      Action a = new AgricolExchangeAction();
    }

    @Test
    public void canExecuteTestWithoutResources() {
      Action a = new AgricolExchangeAction();
      Board b1 = new Board(15, 10);
      
      Player p1 = new AgricolPlayer("Kilian");
      
      a.execute(b1, p1);
      assertEquals(p1.getResource(Resource.Stone), 0);
      assertEquals(p1.getResource(Resource.Sand), 0);
      assertEquals(p1.getResource(Resource.Wheat), 0);
      assertEquals(p1.getResource(Resource.Wood), 0);
      assertEquals(p2.getGold(), 0);
    }

    @Test
    public void canExecuteTestWithResources() {
      Action a = new AgricolExchangeAction();
      Board b1 = new Board(15, 10);

      Player p2 = new AgricolPlayer("Esam", 1, 4, 3, 2, 0);

      a.execute(b1, p2);
      assertEquals(p2.getResource(Resource.Stone), 0);
      assertEquals(p2.getResource(Resource.Sand), 0);
      assertEquals(p2.getResource(Resource.Wheat), 0);
      assertEquals(p2.getResource(Resource.Wood), 0);
      assertEquals(p2.getGold(), 38);
    }
}

