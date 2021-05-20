package game;

/**
 *
 * Representing the different types of resources, 
 * that the characters of the game can collect on the different tiles.
 * Also, each type of tile can produce a specific type of resource.
 *
 */
public enum Resource {

    /**
     * This is the stone resource.
     */
    Stone, 
    /**
     * This is the sand resource. 
     */
    Sand, 
    /**
     * This is the wheat resource. 
     */
    Wheat, 
    /**
     * This is the wood resource.
     */
    Wood;

    /**
     * Conversion value of the stone: 
     * how much gold one stone can be converted to.
     */
    private static int STONE_CONVERSION_VALUE;
    /**
     * Conversion value of the sand: 
     * how much gold one sand can be converted to.
     */
    private static int SAND_CONVERSION_VALUE;
    /**
     * Conversion value of the wheat: 
     * how much gold one wheat can be converted to.
     */
    private static int WHEAT_CONVERSION_VALUE;
    /**
     * Conversion value of the wood: 
     * how much gold one wood can be converted to.
     */
    private static int WOOD_CONVERSION_VALUE;

    /**
     * set the conversion value of the resource <code>r</code> to <code>n</code>.
     * @param r the resource that we want to modify the conversion value.
     * @param i the new conversion value.
     */
    public static void setConversionValue(Resource r, int i) {
        switch (r) {
        case Stone:
            STONE_CONVERSION_VALUE = i;
            break;
        case Wheat:
            WHEAT_CONVERSION_VALUE = i;
            break;
        case Wood:
            WOOD_CONVERSION_VALUE = i;
            break;
        case Sand :
            SAND_CONVERSION_VALUE = i;
            break;
        }
    }

    /**
     * gives the conversion value of the resource.
     * @param r the resource we want to get the conversion value.
     * @return the conversion value of the resource.
     */
    public static int getConversionValue(Resource r) {
        switch (r) {
        case Stone:
            return STONE_CONVERSION_VALUE;
        case Wheat:
            return WHEAT_CONVERSION_VALUE;
        case Wood:
            return WOOD_CONVERSION_VALUE;
        case Sand :
            return SAND_CONVERSION_VALUE;
        default:
            return -1; /* should not occur */
        }
    }
}
