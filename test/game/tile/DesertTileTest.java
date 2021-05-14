package game.tile;

import static org.junit.Assert.*;
import org.junit.Test;
import game.*;
import game.tile.DesertTile;

public class DesertTileTest {

    @Test
    public void getResourceTest() {
        DesertTile t1 = new DesertTile();
        assertSame(Sand, t1.getResource());
    }

}

