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
	 * create a player for the agricol game with the given name.
	 * 
	 * Initially, this player has 15 gold coin and no ressources.
	 * @param name name of this player
	 */
	public AgricolPlayer(String name) {
		super("Bar", 0, 0, 0, 0, 0);
	}
	

	/**
    * convert the player's resource in gold.
    */
	@Override
	public void convertResource() {
		
	}

	
    
}