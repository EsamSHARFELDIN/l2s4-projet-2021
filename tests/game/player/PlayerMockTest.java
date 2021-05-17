package game.player;

import org.junit.*;
import static org.junit.Assert.*;

import game.Resource;
import game.exception.*;
import game.tile.*;
import game.unit.*;

public class PlayerMockTest {
    @Before
    public void init() {
        this.p = new PlayerMock("Luc", 0, 0, 0, 0, 0);
    }

    @Test
    public void canAddUnit() {
        Unit u1 = new Worker();
        Unit u2 = new Army(3);
        this.p.addUnit(u1);
        this.p.addUnit(u2);
        assertEquals(2, this.p.units.size());
        assertSame(u1, this.p.units.get(0));
        assertSame(u2, this.p.units.get(1));
    }

    @Test
    public void canRemoveUnit() {
        Unit u1 = new Worker();
        Unit u2 = new Army(3);
        this.p.addUnit(u1);
        this.p.addUnit(u2);
        this.p.removeUnit(u2);
        assertEquals(1, this.p.units.size());
        assertSame(u1, this.p.units.get(0));
    }

    @Test
    public void canRemoveUnitWhenNotOwnedByPlayer() {
        Unit u1 = new Worker();
        Unit u2 = new Army(3);
        Unit u3 = new Worker();
        this.p.addUnit(u1);
        this.p.addUnit(u2);
        this.p.removeUnit(u3);
        assertEquals(2, this.p.units.size());
        assertSame(u1, this.p.units.get(0));
        assertSame(u2, this.p.units.get(1));
    }

    @Test
    public void canCollectResources() throws IllegalGameActionException {
        Tile plain = new PlainTile(0, 0);
        Tile forest = new ForestTile(0, 0);
        Tile mountain = new MountainTile(0, 0);
        Tile desert = new DesertTile(0, 0);
        Unit u1 = new Worker(plain);
        Unit u2 = new Worker(forest);
        Unit u3 = new Worker(mountain);
        Unit u4 = new Worker(desert);
        this.p.addUnit(u1);
        this.p.addUnit(u2);
        this.p.addUnit(u3);
        this.p.addUnit(u4);
        assertEquals(0, this.p.getResource(Resource.Wheat));
        assertEquals(0, this.p.getResource(Resource.Wood));
        assertEquals(0, this.p.getResource(Resource.Stone));
        assertEquals(0, this.p.getResource(Resource.Sand));
        this.p.collectResources();
        assertEquals(1, this.p.getResource(Resource.Wheat));
        assertEquals(1, this.p.getResource(Resource.Wood));
        assertEquals(1, this.p.getResource(Resource.Stone));
        assertEquals(1, this.p.getResource(Resource.Sand));
    }

    @Test
    public void canGetResources() {
        assertEquals(0, this.p.getResource(Resource.Wheat));
        assertEquals(0, this.p.getResource(Resource.Wood));
        assertEquals(0, this.p.getResource(Resource.Stone));
        assertEquals(0, this.p.getResource(Resource.Sand));
    }

    @Test
    public void canIncrementAndDecrementResources() {
        assertEquals(0, this.p.getResource(Resource.Wheat));
        assertEquals(0, this.p.getResource(Resource.Wood));
        assertEquals(0, this.p.getResource(Resource.Stone));
        assertEquals(0, this.p.getResource(Resource.Sand));
        this.p.incrementResource(12, Resource.Wheat);
        this.p.incrementResource(11, Resource.Wood);
        this.p.incrementResource(10, Resource.Stone);
        this.p.incrementResource(9, Resource.Sand);
        assertEquals(12, this.p.getResource(Resource.Wheat));
        assertEquals(11, this.p.getResource(Resource.Wood));
        assertEquals(10, this.p.getResource(Resource.Stone));
        assertEquals(9, this.p.getResource(Resource.Sand));
        this.p.decrementResource(6, Resource.Wheat);
        this.p.decrementResource(7, Resource.Wood);
        this.p.decrementResource(8, Resource.Stone);
        this.p.decrementResource(9, Resource.Sand);
        assertEquals(6, this.p.getResource(Resource.Wheat));
        assertEquals(4, this.p.getResource(Resource.Wood));
        assertEquals(2, this.p.getResource(Resource.Stone));
        assertEquals(0, this.p.getResource(Resource.Sand));
    }

    @Test
    public void canGetGold() {
        assertEquals(0, this.p.getGold());
    }

    @Test
    public void canIncrementAndDecrementGold() {
        assertEquals(0, this.p.getGold());
        this.p.incrementGold(5);
        assertEquals(5, this.p.getGold());
        this.p.decrementGold(3);
        assertEquals(2, this.p.getGold());
    }
    
    @Test
    public void hasUnitTest() {
    	Unit u = new Worker();
    	
    	assertFalse(p.hasUnit(u));
    	
    	p.addUnit(u);
    	assertTrue(p.hasUnit(u));
    }

    private Player p;
}
