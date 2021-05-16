package game.player;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;
import game.player.AgricolPlayer;
import game.tile.*;
import game.unit.*;

public class AgricolPlayerTest {

    private AgricolPlayer player;

    @BeforeClass
    public static void setAgricolGameContext() {
        Resource.setConversionValue(Resource.Stone, 8);
        Resource.setConversionValue(Resource.Sand, 5);
        Resource.setConversionValue(Resource.Wood, 2);
        Resource.setConversionValue(Resource.Wheat, 2);

        PlainTile.MAX_ARMY_SIZE = 1;
        PlainTile.ADDITIONAL_POWER = 0;
        PlainTile.ADDITIONAL_POINTS = 0;
        PlainTile.GOLD_WHEN_DOING_NOTHING = 1;
        PlainTile.COST_ADD = 1;
        PlainTile.COST_FACTOR = 1;

        MountainTile.MAX_ARMY_SIZE = 1;
        MountainTile.ADDITIONAL_POWER = 0;
        MountainTile.ADDITIONAL_POINTS = 0;
        MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
        MountainTile.COST_ADD = 5;
        MountainTile.COST_FACTOR = 1;

        ForestTile.MAX_ARMY_SIZE = 1;
        ForestTile.ADDITIONAL_POWER = 0;
        ForestTile.ADDITIONAL_POINTS = 0;
        ForestTile.GOLD_WHEN_DOING_NOTHING = 1;
        ForestTile.COST_ADD = 1;
        ForestTile.COST_FACTOR = 1;

        DesertTile.MAX_ARMY_SIZE = 1;
        DesertTile.ADDITIONAL_POWER = 0;
        DesertTile.ADDITIONAL_POINTS = 0;
        DesertTile.GOLD_WHEN_DOING_NOTHING = 2;
        DesertTile.COST_ADD = 3;
        DesertTile.COST_FACTOR = 1;
    }

    @Before
    public void setUp() {
        player = new AgricolPlayer("BarFoo");
    }

    @Test
    public void testConstructor() {
        AgricolPlayer p = new AgricolPlayer("BooFar");

        Resource[] resources = Resource.values();
        for (int i=0; i < resources.length; i++)
            assertSame(0, p.getResource(resources[i]));

        assertSame(15, p.getGold());
    }

    @Test
    public void canAddWorker() {
        Unit u1 = new Worker();
        Unit u2 = new Worker();
        this.player.addUnit(u1);
        this.player.addUnit(u2);
        assertEquals(2, this.player.units.size());
        assertSame(u1, this.player.units.get(0));
        assertSame(u2, this.player.units.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void cannotAddUnitOtherThanWorker() {
        Unit u = new Army(5);
        this.player.addUnit(u);
    }

    @Test
    public void canRemoveWorker() {
        Unit u1 = new Worker();
        Unit u2 = new Worker();
        this.player.addUnit(u1);
        this.player.addUnit(u2);
        this.player.removeUnit(u2);
        assertEquals(1, this.player.units.size());
        assertSame(u1, this.player.units.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void cannotRemoveUnitOtherThanWorker() {
        Unit u1 = new Worker();
        Unit u2 = new Army(5);
        this.player.addUnit(u1);
        this.player.removeUnit(u2);
    }

    @Test
    public void testRemunerateAllWhenSufficientResource() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit w1 = new Worker(p);
        Unit w2 = new Worker(f);
        Unit w3 = new Worker(m);
        Unit w4 = new Worker(d);
        p.setUnit(w1);
        f.setUnit(w2);
        m.setUnit(w3);
        d.setUnit(w4);
        this.player.addUnit(w1);
        this.player.addUnit(w2);
        this.player.addUnit(w3);
        this.player.addUnit(w4);
        assertEquals(4, this.player.units.size());
        assertEquals(15, this.player.getGold());
        this.player.remunerateAll();
        assertEquals(4, this.player.units.size());
        assertEquals(5, this.player.getGold());
        assertSame(w1, p.getUnit());
        assertSame(w2, f.getUnit());
        assertSame(w3, m.getUnit());
        assertSame(w4, d.getUnit());
    }

    @Test
    public void testRemunerateAllWhenNotSufficientResource() throws IllegalGameActionException {
        Tile p1 = new PlainTile(0, 0);
        Tile f1 = new ForestTile(2, 2);
        Tile m1 = new MountainTile(4, 4);
        Tile d1 = new DesertTile(6, 6);
        Tile m2 = new MountainTile(8, 8);
        Tile d2 = new DesertTile(10, 10);
        Tile p2 = new PlainTile(12, 12);
        Unit w1 = new Worker(p1);
        Unit w2 = new Worker(f1);
        Unit w3 = new Worker(m1);
        Unit w4 = new Worker(d1);
        Unit w5 = new Worker(m2);
        Unit w6 = new Worker(d2);
        Unit w7 = new Worker(p2);
        p1.setUnit(w1);
        f1.setUnit(w2);
        m1.setUnit(w3);
        d1.setUnit(w4);
        m2.setUnit(w5);
        d2.setUnit(w6);
        p2.setUnit(w7);
        this.player.addUnit(w1);
        this.player.addUnit(w2);
        this.player.addUnit(w3);
        this.player.addUnit(w4);
        this.player.addUnit(w5);
        this.player.addUnit(w6);
        this.player.addUnit(w7);
        assertEquals(7, this.player.units.size());
        assertEquals(15, this.player.getGold());
        this.player.remunerateAll();
        assertEquals(5, this.player.units.size());
        assertTrue(this.player.units.contains(w1));
        assertTrue(this.player.units.contains(w2));
        assertTrue(this.player.units.contains(w3));
        assertTrue(this.player.units.contains(w4));
        assertTrue(this.player.units.contains(w5));
        assertFalse(this.player.units.contains(w6));
        assertFalse(this.player.units.contains(w7));
        assertEquals(0, this.player.getGold());
        assertSame(w1, p1.getUnit());
        assertSame(w2, f1.getUnit());
        assertSame(w3, m1.getUnit());
        assertSame(w4, d1.getUnit());
        assertSame(w5, m2.getUnit());
        assertFalse(d2.isBusy());
        assertFalse(p2.isBusy());
    }

    @Test
    public void testRemunerateSingleWorker() {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit w1 = new Worker(p);
        Unit w2 = new Worker(f);
        Unit w3 = new Worker(m);
        Unit w4 = new Worker(d);
        assertEquals(15, this.player.getGold());
        this.player.remunerate(w1);
        assertEquals(14, this.player.getGold());
        this.player.remunerate(w2);
        assertEquals(13, this.player.getGold());
        this.player.remunerate(w3);
        assertEquals(8, this.player.getGold());
        this.player.remunerate(w4);
        assertEquals(5, this.player.getGold());
    }

    @Test
    public void testCanRemunerate() {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit w1 = new Worker(p);
        Unit w2 = new Worker(f);
        Unit w3 = new Worker(m);
        Unit w4 = new Worker(d);
        assertTrue(this.player.canRemunerate(w1));
        assertTrue(this.player.canRemunerate(w2));
        assertTrue(this.player.canRemunerate(w3));
        assertTrue(this.player.canRemunerate(w4));
    }

    @Test
    public void testConvertResource() {
        assertEquals(15, this.player.getGold());
        assertEquals(0, this.player.getResource(Resource.Wheat));
        assertEquals(0, this.player.getResource(Resource.Wood));
        assertEquals(0, this.player.getResource(Resource.Stone));
        assertEquals(0, this.player.getResource(Resource.Sand));

        this.player.incrementResource(1, Resource.Wheat);
        assertEquals(15, this.player.getGold());
        assertEquals(1, this.player.getResource(Resource.Wheat));
        assertEquals(0, this.player.getResource(Resource.Wood));
        assertEquals(0, this.player.getResource(Resource.Stone));
        assertEquals(0, this.player.getResource(Resource.Sand));

        this.player.convertResource();
        assertEquals(17, this.player.getGold());
        assertEquals(0, this.player.getResource(Resource.Wheat));
        assertEquals(0, this.player.getResource(Resource.Wood));
        assertEquals(0, this.player.getResource(Resource.Stone));
        assertEquals(0, this.player.getResource(Resource.Sand));

        this.player.incrementResource(1, Resource.Wheat);
        this.player.incrementResource(2, Resource.Wood);
        this.player.incrementResource(3, Resource.Stone);
        this.player.incrementResource(4, Resource.Sand);
        assertEquals(17, this.player.getGold());
        assertEquals(1, this.player.getResource(Resource.Wheat));
        assertEquals(2, this.player.getResource(Resource.Wood));
        assertEquals(3, this.player.getResource(Resource.Stone));
        assertEquals(4, this.player.getResource(Resource.Sand));

        this.player.convertResource();
        assertEquals(67, this.player.getGold());
        assertEquals(0, this.player.getResource(Resource.Wheat));
        assertEquals(0, this.player.getResource(Resource.Wood));
        assertEquals(0, this.player.getResource(Resource.Stone));
        assertEquals(0, this.player.getResource(Resource.Sand));
    }

    @Test
    public void testScore() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit w1 = new Worker(p);
        Unit w2 = new Worker(f);
        Unit w3 = new Worker(m);
        Unit w4 = new Worker(d);
        p.setUnit(w1);
        f.setUnit(w2);
        m.setUnit(w3);
        d.setUnit(w4);
        this.player.addUnit(w1);
        this.player.addUnit(w2);
        this.player.addUnit(w3);
        this.player.addUnit(w4);
        assertEquals(0, this.player.score());
        this.player.remunerateAll();
        assertEquals(10, this.player.score());
    }

    @Test
    public void testCollectIdleGold() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit w1 = new Worker(p);
        Unit w2 = new Worker(f);
        Unit w3 = new Worker(m);
        Unit w4 = new Worker(d);
        p.setUnit(w1);
        f.setUnit(w2);
        m.setUnit(w3);
        d.setUnit(w4);
        this.player.addUnit(w1);
        this.player.addUnit(w2);
        this.player.addUnit(w3);
        this.player.addUnit(w4);
        assertEquals(15, this.player.getGold());
        this.player.collectIdleGold();
        assertEquals(19, this.player.getGold());
    }
}
