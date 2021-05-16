package game.unit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import game.Resource;
import game.player.*;
import game.tile.*;

public class WorkerTest {
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

    @Test
    public void testConstructor() {
        Tile t = new PlainTile(0, 0);
        Player p = new AgricolPlayer("Abel");
        Worker w1 = new Worker(t, p);
        Worker w2 = new Worker(t);
        Worker w3 = new Worker();
    }

    @Test
    public void testIdleGold() {
        Worker w = new Worker();
        Tile p = new PlainTile(0, 0);
        w.setTile(p);
        assertEquals(1, w.goldcoinWhenplayerDoesNothing());
        Tile f = new ForestTile(0, 0);
        w.setTile(f);
        assertEquals(1, w.goldcoinWhenplayerDoesNothing());
        Tile m = new MountainTile(0, 0);
        w.setTile(m);
        assertEquals(0, w.goldcoinWhenplayerDoesNothing());
        Tile d = new DesertTile(0, 0);
        w.setTile(d);
        assertEquals(2, w.goldcoinWhenplayerDoesNothing());
    }

    @Test
    public void testCost() {
        Worker w = new Worker();
        Tile p = new PlainTile(0, 0);
        w.setTile(p);
        assertEquals(1, w.cost());
        Tile f = new ForestTile(0, 0);
        w.setTile(f);
        assertEquals(1, w.cost());
        Tile m = new MountainTile(0, 0);
        w.setTile(m);
        assertEquals(5, w.cost());
        Tile d = new DesertTile(0, 0);
        w.setTile(d);
        assertEquals(3, w.cost());
    }
}
