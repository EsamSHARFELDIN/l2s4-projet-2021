package game.player;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;
import game.player.WarPlayer;
import game.tile.*;
import game.unit.*;

public class WarPlayerTest {

    private WarPlayer player;

    @BeforeClass
    public static void setAgricolGameContext() {
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

    @Before
    public void before() {
        this.player = new WarPlayer("Alice");
    }

    @Test
    public void testConstructor() {
        WarPlayer p = new WarPlayer("FooBar");

        assertEquals(35, p.getWarriorStock());
        assertEquals(10, p.getFoodStock());
        assertEquals(0, p.getGold());
    }

    @Test
    public void canAddArmy() {
        Unit u1 = new Army(3);
        Unit u2 = new Army(2);
        this.player.addUnit(u1);
        this.player.addUnit(u2);
        assertEquals(2, this.player.units.size());
        assertSame(u1, this.player.units.get(0));
        assertSame(u2, this.player.units.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void cannotAddUnitOtherThanArmy() {
        Unit u = new Worker();
        this.player.addUnit(u);
    }

    @Test
    public void canRemoveArmy() {
        Unit u1 = new Army(3);
        Unit u2 = new Army(2);
        this.player.addUnit(u1);
        this.player.addUnit(u2);
        this.player.removeUnit(u2);
        assertEquals(1, this.player.units.size());
        assertSame(u1, this.player.units.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void cannotRemoveUnitOtherThanArmy() {
        Unit u1 = new Army(5);
        Unit u2 = new Worker();
        this.player.addUnit(u1);
        this.player.removeUnit(u2);
    }

    @Test
    public void testRemunerateAllWhenSufficientResource() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit a1 = new Army(p, this.player, 2);
        Unit a2 = new Army(f, this.player, 1);
        Unit a3 = new Army(m, this.player, 3);
        Unit a4 = new Army(d, this.player, 2);
        p.setUnit(a1);
        f.setUnit(a2);
        m.setUnit(a3);
        d.setUnit(a4);
        this.player.addUnit(a1);
        this.player.addUnit(a2);
        this.player.addUnit(a3);
        this.player.addUnit(a4);
        assertEquals(4, this.player.units.size());
        assertEquals(10, this.player.getFoodStock());
        this.player.remunerateAll();
        assertEquals(4, this.player.units.size());
        assertEquals(0, this.player.getFoodStock());
        assertSame(a1, p.getUnit());
        assertSame(a2, f.getUnit());
        assertSame(a3, m.getUnit());
        assertSame(a4, d.getUnit());
    }

    @Test
    public void testRemunerateAllWhenNotSufficientResource() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit a1 = new Army(p, this.player, 2);
        Unit a2 = new Army(f, this.player, 1);
        Unit a3 = new Army(m, this.player, 3);
        Unit a4 = new Army(d, this.player, 3);
        p.setUnit(a1);
        f.setUnit(a2);
        m.setUnit(a3);
        d.setUnit(a4);
        this.player.addUnit(a1);
        this.player.addUnit(a2);
        this.player.addUnit(a3);
        this.player.addUnit(a4);
        assertEquals(4, this.player.units.size());
        assertEquals(10, this.player.getFoodStock());
        assertEquals(0, this.player.getGold());
        this.player.remunerateAll();
        assertEquals(3, this.player.units.size());
        assertTrue(this.player.units.contains(a1));
        assertTrue(this.player.units.contains(a2));
        assertTrue(this.player.units.contains(a3));
        assertFalse(this.player.units.contains(a4));
        assertEquals(4, this.player.getFoodStock());
        assertEquals(1, this.player.getGold());
        assertSame(a1, p.getUnit());
        assertSame(a2, f.getUnit());
        assertSame(a3, m.getUnit());
        assertFalse(d.isBusy());
    }

    @Test
    public void testRemunerateSingleWorker() {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit a1 = new Army(p, this.player, 2);
        Unit a2 = new Army(f, this.player, 1);
        Unit a3 = new Army(m, this.player, 3);
        Unit a4 = new Army(d, this.player, 2);
        assertEquals(10, this.player.getFoodStock());
        this.player.remunerate(a1);
        assertEquals(8, this.player.getFoodStock());
        this.player.remunerate(a2);
        assertEquals(7, this.player.getFoodStock());
        this.player.remunerate(a3);
        assertEquals(4, this.player.getFoodStock());
        this.player.remunerate(a4);
        assertEquals(0, this.player.getFoodStock());
    }

    @Test
    public void testCanRemunerate() {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit a1 = new Army(p, this.player, 2);
        Unit a2 = new Army(f, this.player, 1);
        Unit a3 = new Army(m, this.player, 3);
        Unit a4 = new Army(d, this.player, 3);
        assertTrue(this.player.canRemunerate(a1));
        this.player.remunerate(a1);
        assertTrue(this.player.canRemunerate(a2));
        this.player.remunerate(a2);
        assertTrue(this.player.canRemunerate(a3));
        this.player.remunerate(a3);
        assertFalse(this.player.canRemunerate(a4));
    }

    @Test
    public void testConvertResource() {
        int initFoodStock = player.getFoodStock();

        //test that convertResource() call does not throw an exception
        player.convertResource();

        assertTrue(initFoodStock <= player.getFoodStock());
    }

    @Test
    public void testScore() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        Tile f = new ForestTile(2, 2);
        Tile m = new MountainTile(4, 4);
        Tile d = new DesertTile(6, 6);
        Unit a1 = new Army(p, this.player, 2);
        Unit a2 = new Army(f, this.player, 1);
        Unit a3 = new Army(m, this.player, 2);
        Unit a4 = new Army(d, this.player, 1);
        p.setUnit(a1);
        f.setUnit(a2);
        m.setUnit(a3);
        d.setUnit(a4);
        this.player.addUnit(a1);
        this.player.addUnit(a2);
        this.player.addUnit(a3);
        this.player.addUnit(a4);
        a1.receiveGold(2);
        a3.receiveGold(4);
        assertEquals(17, this.player.score());
        this.player.remunerateAll();
        assertEquals(17, this.player.score());
        this.player.remunerateAll();
        assertEquals(7, this.player.score());
        this.player.remunerateAll();
        assertEquals(4, this.player.score());
        this.player.remunerateAll();
        assertEquals(4, this.player.score());
    }

    @Test
    public void testScore10ArmiesBonus() throws IllegalGameActionException {
        Tile p1 = new PlainTile(0, 0);
        Tile p2 = new PlainTile(1, 1);
        Tile p3 = new PlainTile(2, 2);
        Tile p4 = new PlainTile(3, 3);
        Tile p5 = new PlainTile(4, 4);
        Tile p6 = new PlainTile(5, 5);
        Tile p7 = new PlainTile(6, 6);
        Tile p8 = new PlainTile(7, 7);
        Tile p9 = new PlainTile(8, 8);
        Tile p10 = new PlainTile(9, 9);
        Unit a1 = new Army(p1, this.player, 1);
        Unit a2 = new Army(p2, this.player, 1);
        Unit a3 = new Army(p3, this.player, 1);
        Unit a4 = new Army(p4, this.player, 1);
        Unit a5 = new Army(p5, this.player, 1);
        Unit a6 = new Army(p6, this.player, 1);
        Unit a7 = new Army(p7, this.player, 1);
        Unit a8 = new Army(p8, this.player, 1);
        Unit a9 = new Army(p9, this.player, 1);
        Unit a10 = new Army(p10, this.player, 1);
        p1.setUnit(a1);
        p2.setUnit(a2);
        p3.setUnit(a3);
        p4.setUnit(a4);
        p5.setUnit(a5);
        p6.setUnit(a6);
        p7.setUnit(a7);
        p8.setUnit(a8);
        p9.setUnit(a9);
        p10.setUnit(a10);
        this.player.addUnit(a1);
        this.player.addUnit(a2);
        this.player.addUnit(a3);
        this.player.addUnit(a4);
        this.player.addUnit(a5);
        this.player.addUnit(a6);
        this.player.addUnit(a7);
        this.player.addUnit(a8);
        this.player.addUnit(a9);
        this.player.addUnit(a10);
        assertEquals(15, this.player.score());
        this.player.remunerateAll();
        assertEquals(15, this.player.score());
        this.player.remunerateAll();
        assertEquals(10, this.player.score());
        this.player.remunerateAll();
        assertEquals(10, this.player.score());
    }

    @Test
    public void testDecrementFoodStock() {
        player.decrementFoodStock(5);

        assertEquals(5, player.getFoodStock());
    }

    @Test
    public void testDecrementWarriorStock() {
        player.decrementWarriorStock(5);

        assertEquals(30, player.getWarriorStock());
    }

    @Test
    public void testGetFoodStock() {
        assertEquals(10, player.getFoodStock());

        player.decrementFoodStock(1);
        assertEquals(9, player.getFoodStock());

        player.incrementFoodStock(10);
        assertEquals(19, player.getFoodStock());
    }

    @Test
    public void testGetWarriorStock() {
        assertEquals(35, player.getWarriorStock());

        player.incrementWarriorStock(10);
        assertEquals(45, player.getWarriorStock());

        player.decrementWarriorStock(15);
        assertEquals(30, player.getWarriorStock());
    }

    @Test
    public void testIncrementFoodStock() {
        player.incrementFoodStock(1000);

        assertEquals(1010, player.getFoodStock());
    }

    @Test
    public void testIncrementWarriorStock() {
        player.incrementWarriorStock(100000);

        assertEquals(100035, player.getWarriorStock());
    }
}
