package game.unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import game.Resource;
import game.exception.IllegalGameActionException;
import game.player.*;
import game.tile.*;

public class UnitMockTest {
    Player p;
    Tile t;
    Unit u;

    @Before
    public void init() {
        this.p = new AgricolPlayer("Test");
        this.t = new PlainTile(0, 0);
        this.u = new UnitMock(this.t, this.p);
    }

    @Test
    public void canConstruct() {
        Unit u1 = new UnitMock(t, p);
        Unit u2 = new UnitMock(t);
        Unit u3 = new UnitMock();
    }

    @Test
    public void canGetTile() {
        assertSame(this.t, this.u.getTile());
    }

    @Test
    public void canSetTile() {
        assertSame(this.t, this.u.getTile());
        Tile t2 = new DesertTile(1, 1);
        this.u.setTile(t2);
        assertSame(t2, this.u.getTile());
    }

    @Test
    public void canGetPlayer() {
        assertSame(this.p, this.u.getPlayer());
    }

    @Test
    public void canSetPlayer() {
        assertSame(this.p, this.u.getPlayer());
        Player p2 = new AgricolPlayer("Abel");
        this.u.setPlayer(p2);
        assertSame(p2, this.u.getPlayer());
    }

    @Test
    public void canGetGold() {
        assertEquals(0, this.u.getGold());
    }

    @Test
    public void canReceiveGold() {
        assertEquals(0, this.u.getGold());
        this.u.receiveGold(12);
        assertEquals(12, this.u.getGold());
    }

    @Test
    public void canDestroyUnit() throws IllegalGameActionException {
        this.t.setUnit(u);
        assertSame(this.u, this.t.getUnit());
        this.u.destroy();
        assertSame(null, this.t.getUnit());
    }

    @Test
    public void canProvideResource() throws IllegalGameActionException {
        Tile p = new PlainTile(0, 0);
        this.u.setTile(p);
        assertSame(Resource.Wheat, this.u.provideResource());
        Tile f = new ForestTile(0, 0);
        this.u.setTile(f);
        assertSame(Resource.Wood, this.u.provideResource());
        Tile m = new MountainTile(0, 0);
        this.u.setTile(m);
        assertSame(Resource.Stone, this.u.provideResource());
        Tile d = new DesertTile(0, 0);
        this.u.setTile(d);
        assertSame(Resource.Sand, this.u.provideResource());
    }

    @Test(expected = IllegalGameActionException.class)
    public void cannotProvideResourceIfNoResourceTile() throws IllegalGameActionException {
        Tile o = new OceanTile(0, 0);
        this.u.setTile(o);
        this.u.provideResource();
    }

    @Test
    public void canGetPoints() {
        assertEquals(0, this.u.points());
        this.u.receiveGold(12);
        assertEquals(12, this.u.points());
    }

    @Test
    public void testHasTile() {
        Unit u1 = new UnitMock();
        assertFalse(u1.hasTile());
        u1.setTile(this.t);
        assertTrue(u1.hasTile());
    }
}
