package game;

import static org.junit.Assert.*;
import org.junit.Test;
import game.*;

public class ForestTileTest {

    @Test
    public void getResourceTest(){
        ForestTile t1 = new ForestTile();
        assertSame(Wood, t1.getResource());
    }

}
