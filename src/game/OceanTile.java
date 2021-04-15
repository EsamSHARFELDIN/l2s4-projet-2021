package game;
/**
 * This class models a tile which is supposed to
 * be a ocean area in the game with its
 * characteristics: a deep blue ocean ... that
 * may imply something in the game proceeding.
 */
public class OceanTile extends Tile {

    /**
     * Create an ocean type tile.
     */
    public OceanTile() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Tile#getResource()
     * Exceptionally, this area does not give any resource.
     * @return it's supposed to return nothing but only
     * throws an exception.
     * @throws IllegalGameActionException this method always
     * throws this exception because it's supposed to not give
     * any resources.
     */
    public Resource getResource() throws IllegalGameActionException {
        // TODO
        return null;
    }

    /**
     * @see Tile#isBusy()
     * Since no unit can be placed in this tile, it's always busy.
     * @return always <code>true</code>.
     */
    public boolean isBusy() {
        // TODO
        return true;
    }

    /**
     * @see Tile#setUnit(Unit)
     * Since unit can't be placed on ocean tile, this
     * method always throws an exception
     *
     * @param u the unit that is supposed to be placed.
     * @throws IllegalGameActionException Since unit
     * can't be placed on ocean tile, this method always
     * throws an exception.
     */
    public void setUnit(Unit u) throws IllegalGameActionException {
        //TODO
    }

    public void print() {
        System.out.print("O");
    }
}
