package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;

public class DesertTileTest {
    @Test
    public void getResourceTest() throws IllegalGameActionException {
        Tile tile = new DesertTile(0, 0);
        assertSame(Resource.Sand, tile.getResource());
    }
}
