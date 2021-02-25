package game;

import java.util.List;

/**
 * this is abstract class, it used to represent a player.
 * 
 *
 */
public abstract class Player {
	/**
	 * @param theUnits the list of characters he controls.
	 */
	protected String name;
    protected List<Unit> theUnits;
    protected int rockStock;
    protected int sandStock;
    protected int wheatStock;
    protected int woodStock;
    protected int goldStock;
    
    /**
     * 
     * @param name the name of the player
     * @param rockStock
     * @param sandStock
     * @param wheatStock
     * @param woodStock
     * @param goldStock
     */
	public Player(String name, int rockStock, int sandStock, int wheatStock, int woodStock, int goldStock) {
		
		this.name = name;
		this.rockStock = rockStock;
		this.sandStock = sandStock;
		this.wheatStock = wheatStock;
		this.woodStock = woodStock;
		this.goldStock = goldStock;
	}
	
	
	/**
	 * represent the action chosen by the player.
	 * @return an instance of a class implementing the Action.
	 */
	public Action chooseAction() {
		return null;
	}
	
	
	/**
	 * to collect the resources owned by the player.
	 * 
	 */
	public void collectResources(){
		
	}
	
	
	
	/**
	 * 
	 * @param unit
	 */
	public void addUnit(Unit unit){

	}
	
	
	
	/**
	 * 
	 * @param unit
	 */
	public void removeUnit(Unit unit){

	}
	
	
	/**
	 *  allows the player to pay the cost of maintaining a unit.
	 */
	public void remunerate(Unit unit){

	}
	
	
	
	/**
	 * to know if the resources of the player allow him to maintain one of his units.
	 * @return
	 */
	public boolean canResourcet(){
		return true;

	}
	
	
	/**
	 * is an abstract method, to converting a player's resources into other resources.
	 */
	public abstract void convertResource();
	
	
	
	/**
	 * to get the player resource.
	 * @param resource
	 * @return
	 */
	public int getResource(Resource resource){
		return 0;

	}
	
	
	/**
	 * to increase the player resource
	 * @param i
	 * @param resource the resource of the player
	 */
	public void incrementResource(int i, Resource resource) {
		
	}
	
	
	/**
	 * to decrease the player resource
	 * @param i
	 * @param resource the resource of the player
	 */
	public void decrementResource(int i, Resource resource) {
		
	}


    
}
