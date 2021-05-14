package game.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import game.unit.Worker;

public class workerTest {

    private Worker worker;
    
    @Test
    public void testConstructor() {

        Worker w = new Worker(t1, player1);
        assertSame(t1, w.getTile());
        assertSame(player1, w.getPlayer());
    }

    // goldcoinWhenplayerDoesNothing ?
    // cost ?

}

