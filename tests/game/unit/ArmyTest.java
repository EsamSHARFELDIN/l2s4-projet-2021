package game.unit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import game.Resource;
import game.player.*;
import game.tile.*;

public class ArmyTest {
    @BeforeClass
    public static void setWarGameContext() {
        Resource.setConversionValue(Resource.Stone, 0);
        Resource.setConversionValue(Resource.Sand, 0);
        Resource.setConversionValue(Resource.Wood, 1);
        Resource.setConversionValue(Resource.Wheat, 5);

        PlainTile.MAX_ARMY_SIZE = 5;
        PlainTile.ADDITIONAL_POWER = 0;
        PlainTile.ADDITIONAL_POINTS = 1;
        PlainTile.GOLD_WHEN_DOING_NOTHING = 0;
        PlainTile.COST_ADD = 0;
        PlainTile.COST_FACTOR = 1;

        MountainTile.MAX_ARMY_SIZE = 3;
        MountainTile.ADDITIONAL_POWER = 2;
        MountainTile.ADDITIONAL_POINTS = 4;
        MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
        MountainTile.COST_ADD = 0;
        MountainTile.COST_FACTOR = 1;

        ForestTile.MAX_ARMY_SIZE = 5;
        ForestTile.ADDITIONAL_POWER = 0;
        ForestTile.ADDITIONAL_POINTS = 2;
        ForestTile.GOLD_WHEN_DOING_NOTHING = 0;
        ForestTile.COST_ADD = 0;
        ForestTile.COST_FACTOR = 1;

        DesertTile.MAX_ARMY_SIZE = 3;
        DesertTile.ADDITIONAL_POWER = 0;
        DesertTile.ADDITIONAL_POINTS = 4;
        DesertTile.GOLD_WHEN_DOING_NOTHING = 0;
        DesertTile.COST_ADD = 0;
        DesertTile.COST_FACTOR = 2;
    }

    @Test
    public void canConstructArmy() throws IllegalArgumentException{
        Tile t = new PlainTile(0, 0);
        Player p = new WarPlayer("Samson");
        Army a1 = new Army(t, p, 5);
        Army a2 = new Army(t, 3);
        Army a3 = new Army(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConstructArmyIfSizeLessThan1() throws IllegalArgumentException {
        Army a = new Army(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConstructArmyIfSizeMoreThanMax() throws IllegalArgumentException {
        Tile t = new MountainTile(0, 0);
        Army a = new Army(t, 4);
    }

    @Test
    public void canGetAndSetSize() {
        Tile t = new MountainTile(0, 0);
        Player p = new WarPlayer("Samson");
        Army a = new Army(t, p, 1);
        assertEquals(1, a.getSize());
        a.incrementSize(1);
        assertEquals(2, a.getSize());
        a.incrementSize(4);
        assertEquals(3, a.getSize());
        a.decrementSize(1);
        assertEquals(2, a.getSize());
        a.decrementSize(5);
        assertEquals(1, a.getSize());
    }

    @Test
    public void canSetSizeWithSet() {
        Tile t = new MountainTile(0, 0);
        Player p = new WarPlayer("Samson");
        Army a = new Army(t, p, 1);
        assertEquals(1, a.getSize());
        a.setSize(2);
        assertEquals(2, a.getSize());
        a.setSize(0);
        assertEquals(1, a.getSize());
        a.setSize(5);
        assertEquals(3, a.getSize());
    }

    @Test
    public void testMilitaryStrength() {
        Tile t = new MountainTile(0, 0);
        Player p = new WarPlayer("Samson");
        Army a = new Army(t, p, 1);
        assertEquals(1, a.getSize());
        assertEquals(3, a.militaryStrength());
        a.incrementSize(2);
        assertEquals(3, a.getSize());
        assertEquals(5, a.militaryStrength());
    }

    @Test
    public void testCost() {
        Army a = new Army(3);
        Tile p = new PlainTile(0, 0);
        a.setTile(p);
        assertEquals(3, a.cost());
        Tile f = new ForestTile(0, 0);
        a.setTile(f);
        assertEquals(3, a.cost());
        Tile m = new MountainTile(0, 0);
        a.setTile(m);
        assertEquals(3, a.cost());
        Tile d = new DesertTile(0, 0);
        a.setTile(d);
        assertEquals(6, a.cost());
    }

    @Test
    public void testPoints() {
        Army a = new Army(3);
        Tile p = new PlainTile(0, 0);
        a.setTile(p);
        assertEquals(1, a.points());
        Tile f = new ForestTile(0, 0);
        a.setTile(f);
        assertEquals(2, a.points());
        Tile m = new MountainTile(0, 0);
        a.setTile(m);
        assertEquals(4, a.points());
        Tile d = new DesertTile(0, 0);
        a.setTile(d);
        assertEquals(4, a.points());

        a.receiveGold(5);
        a.setTile(p);
        assertEquals(6, a.points());
        a.setTile(f);
        assertEquals(7, a.points());
        a.setTile(m);
        assertEquals(9, a.points());
        a.setTile(d);
        assertEquals(9, a.points());
    }
}
