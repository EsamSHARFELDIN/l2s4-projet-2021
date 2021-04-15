package game;

import static org.junit.Assert.*;
import org.junit.Test;
import game.*;

public class PlainTileTest {

    @Test
    public void getResourceTest() {
        PlainTile t1 = new PlainTile();
        assertSame(Wheat, t1.getResource());
    }
}
