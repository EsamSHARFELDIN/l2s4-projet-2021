package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;

public class PlainTileTest {
    @Test
    public void getResourceTest() throws IllegalGameActionException {
        Tile tile = new PlainTile(0, 0);
        assertSame(Resource.Wheat, tile.getResource());
    }
}
