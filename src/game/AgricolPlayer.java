package game;

/**
 * This class modelize a Player of an agricol game.
 * This class extends the Unit class (@see Player).
 */

public class AgricolPlayer extends Player{
	
	/**
    * create a Player with given name.
    * @param name the name of the Player.
    */
	public AgricolPlayer(String name, int rockStock, int sandStock, int wheatStock, int woodStock, int goldStock) {
		super(name, rockStock, sandStock, wheatStock, woodStock, goldStock);
		
	}
	

	/**
    * convert the player's resource in gold.
    */
	@Override
	public void convertResource() {
		
	}

	
    
}