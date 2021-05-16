package game.tile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.exception.IllegalGameActionException;
import game.tile.TileMock;
import game.unit.Unit;
import game.unit.Worker;

public class TileMockTest {

    private TileMock tile;
    private Unit unit;

    @Before
    public void setUp() throws Exception {
        tile = new TileMock(5, 12);
        unit = new Worker(null, null);
    }

    @Test
    public void canGetCoordinates() {
        assertEquals(5, this.tile.getX());
        assertEquals(12, this.tile.getY());
    }

    @Test
    public void testConstructor() {
        assertFalse(tile.isBusy());
        assertNull(tile.getUnit());
    }

    @Test
    public void testIsBusy() throws IllegalGameActionException {
        assertFalse(tile.isBusy());

        tile.setUnit(unit);
        assertTrue(tile.isBusy());
    }

    @Test
    public void testGetUnit() throws IllegalGameActionException {
        assertNull(tile.getUnit());

        tile.setUnit(unit);
        assertSame(unit, tile.getUnit());
    }

    @Test
    public void testSetUnit() throws IllegalGameActionException {
        tile.setUnit(unit);
        assertSame(unit, tile.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetUnitWithNullArgument() throws IllegalGameActionException {
        tile.setUnit(null);
    }

    @Test
    public void testUnsetUnit() throws IllegalGameActionException {
        assertFalse(tile.isBusy());
        tile.unsetUnit();

        tile.setUnit(unit);
        tile.unsetUnit();
        assertFalse(tile.isBusy());
    }
}
