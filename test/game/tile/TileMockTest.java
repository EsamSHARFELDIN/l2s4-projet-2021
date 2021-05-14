package game.tile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Unit;
import game.Worker;
import game.tile.TileMock;

public class TileMockTest {

	private TileMock tile;
	private Unit unit;
	
	@Before
	public void setUp() throws Exception {
		tile = new TileMock();
		unit = new Worker(null, null);
	}

	@Test
	public void testGetResource() {
		assertNull(tile.getResource()); // It's null since this is just a mock tile.
	}

	@Test
	public void testConstructor() {
		assertFalse(tile.isBusy());
		assertNull(tile.getUnit());
	}

	@Test
	public void testIsBusy() {
		assertFalse(tile.isBusy());
		
		tile.setUnit(unit);
		assertTrue(tile.isBusy());
	}

	@Test
	public void testGetUnit() {
		assertNull(tile.getUnit());
		
		
		tile.setUnit(unit);
		assertSame(unit, tile.getUnit());
	}

	@Test
	public void testSetUnit() {
		tile.setUnit(unit);
		assertSame(unit, tile.getUnit());
		
		tile.setUnit(null);
		assertSame(unit, tile.getUnit());
	}
	
	@Test
	public void testUnsetUnit() {
		assertFalse(tile.isBusy());
		tile.unsetUnit();
		
		tile.setUnit(unit);
		tile.unsetUnit();
		assertFalse(tile.isBusy());
	}

}
