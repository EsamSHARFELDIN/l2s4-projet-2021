package game;
import game.Resouce;
import game.Unit;

public abstract class Tile {
    protected Unit unit;
    /**
     * 
     */
    public Tile(){

    }
    /**
     * 
     * @param u
     * @return
     */
    public boolean isBusy(Unit u){
        return true;
    }
    /**
     * 
     * @return
     */
    public abstract Resource getResource(){
        return resource;
    }   
    /**
     * 
     * @return
     */
    public Unit getUnit(){

    }
    /**
     * 
     * @param u
     */
    public void setUnit(Unit u){
    
    }
}
