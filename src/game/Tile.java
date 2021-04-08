package game;
import game.Resouce;
import game.Unit;

/**
 * This class is use to represents the Tile of the board.
 */

public abstract class Tile {
    protected Unit unit;
    /**
     * Creates a new tile.
     */
    public Tile(){

    }

    /**
     * This allows to know if a tile is busy or not.
     * @return true if the tile is busy, otherwise false.
     */
    public boolean isBusy(){
        return true;
    }

    /**
     * Gives the ressource given by the tile.
     */
    public abstract Resource getResource(){

    }

    /**
     * Gives the unit posted on the tile.
     * @return The unit posted on the tile.
     */
    public Unit getUnit(){
        return unit;
    }
    /**
     * This allows to change the unit post on the tile.
     * @param u the unit that we want to post on the tile
     */
    public void setUnit(Unit u){
    
    }
}
