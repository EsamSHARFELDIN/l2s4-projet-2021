package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;
import game.*;
import game.tile.ForestTile;

public class ForestTileTest {

    @Test
    public void getResourceTest(){
        ForestTile t1 = new ForestTile();
        assertSame(Wood, t1.getResource());
    }

}
