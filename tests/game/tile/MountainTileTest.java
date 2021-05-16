package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;

public class MountainTileTest {
    @Test
    public void getResourceTest() throws IllegalGameActionException {
        Tile tile = new MountainTile(0, 0);
        assertSame(Resource.Stone, tile.getResource());
    }
}
