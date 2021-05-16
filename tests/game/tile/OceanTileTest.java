package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import game.exception.IllegalGameActionException;
import game.unit.Unit;
import game.unit.Worker;

public class OceanTileTest {
    private OceanTile t1 = new OceanTile(0, 0);
    private Unit u1 = new Worker();

    @Test
    public void IsBusyTest(){
        assertTrue(this.t1.isBusy());
    }

    @Test(expected = IllegalGameActionException.class)
    public void cannotGetResource() throws IllegalGameActionException {
        this.t1.getResource();
    }

    @Test(expected = IllegalGameActionException.class)
    public void cannotSetUnit() throws IllegalGameActionException {
        this.t1.setUnit(u1);
    }
}
