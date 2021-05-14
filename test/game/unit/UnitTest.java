package game.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import game.unit.Unit;

public class unitTest {

    private Unit unit;

    @Test
    public void testConstructor() {
        
        Unit u = new Unit(t,player1);
        assertSame(t, u.getTile());
        assertSame(player1, u.getPlayer());
        assertEquals(0,u.getGold());
    }

    @Test
    public void testSetTile() {

        Unit u2 = new Unit(t2,player2);

        u.setTile(t3);
        assertSame(t3, u.getTile());
        u.setTile(t2);
        assertSame(t3, u.getTile());
    }

    @Test
    public void testSetPlayer() {

        u.setPlayer(player2);
        assertSame(player2, u.getPlayer());
    }

    @Test
    public void testReceiveGold() {

        u.receiveGold(5);
        assertEquals(5, u.getGold());
        u.receiveGold(6);
        assertEquals(11, u.getGold());
    }

        /* u.destroy();
        assertEquals() ? */

        // provide ressource ?

        // cost ?

        // points ?

    }


}