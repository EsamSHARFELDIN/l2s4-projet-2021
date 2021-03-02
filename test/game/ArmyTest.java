package game;

import static org.junit.Assert.*;

import game.Army;
import org.junit.Test;

public class armyTest {

    private Army army;

    @Test(excepted = IllagalArgumentException.class)
    public void testConstructor() {

        Army a = new Army(t1, player1, 1);
        assertSame(t1, a.getTile());
        assertSame(player1, a.getPlayer());
        assertEquals(1, a.getSize());

        Army a2 = new Army(t2, player1, 6);

    }


    @Test
    public void testSize() {
        a.incrementSize(3);
        assertEquals(4, a.getSize());
        a.decrementSize(2);
        assertEquals(2, a.getSize());
    }

    // militaryStrength ?
    // cost ?
    // points ?
}
