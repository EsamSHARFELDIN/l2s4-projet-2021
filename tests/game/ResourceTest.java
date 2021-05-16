package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ResourceTest {

    @Before
    public void setUp() throws Exception {
        Resource.setConversionValue(Resource.Stone, 0);
        Resource.setConversionValue(Resource.Sand, 1);
        Resource.setConversionValue(Resource.Wheat, 2);
        Resource.setConversionValue(Resource.Wood, 3);
    }

    @Test
    public void testSetConversionValue() {
        Resource.setConversionValue(Resource.Stone, 0);
        Resource.setConversionValue(Resource.Sand, 10);
        Resource.setConversionValue(Resource.Wheat, 20);
        Resource.setConversionValue(Resource.Wood, 30);

        assertSame(0, Resource.getConversionValue(Resource.Stone));
        assertSame(10, Resource.getConversionValue(Resource.Sand));
        assertSame(20, Resource.getConversionValue(Resource.Wheat));
        assertSame(30, Resource.getConversionValue(Resource.Wood));
    }

    @Test
    public void getConversionValueNormally() {
        assertSame(0, Resource.getConversionValue(Resource.Stone));
        assertSame(1, Resource.getConversionValue(Resource.Sand));
        assertSame(2, Resource.getConversionValue(Resource.Wheat));
        assertSame(3, Resource.getConversionValue(Resource.Wood));
    }

    @Test(expected=NullPointerException.class)
    public void getConversionValueOfNull() {
        Resource.getConversionValue(null);
    }

}
