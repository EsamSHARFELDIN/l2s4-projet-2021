package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Resource;
import game.exception.IllegalGameActionException;

public class ForestTileTest {
    @Test
    public void getResourceTest() throws IllegalGameActionException {
        Tile tile = new ForestTile(0, 0);
        assertSame(Resource.Wood, tile.getResource());
    }
}
