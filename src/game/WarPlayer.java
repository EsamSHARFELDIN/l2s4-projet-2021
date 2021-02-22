package game;

/**
 * This class modelize a Player of a war game.
 * This class extends the Unit class (@see Player).
 */

public class WarPlayer extends Player {
	/**
	 * the player's stock of warrior (35 at the start).
	 */
	
	protected int warriorStock = 35;
	/**
	 * the player's stock of food.
	 */
	protected int foodStock;
	/**
	 * create a player with given name
	 * @param name the name of player
	 * @param rockStock
	 * @param sandStock
	 * @param wheatStock
	 * @param woodStock
	 * @param goldStock
	 * @param warriorStock
	 * @param foodStock
	 */
	public WarPlayer(String name, int rockStock, int sandStock, int wheatStock, int woodStock, int goldStock, int warriorStock, int foodStock) {
		super(name, rockStock, sandStock, wheatStock, woodStock, goldStock);
		this.warriorStock = warriorStock;
		this.foodStock = foodStock;
	}
	/**
	 * convert the player's ressource in food.
	 */
	@Override
	public void convertResource() {
				
	}
	/**
	 * gives the number of warriors remaining to the player.
     * @return the number of warriors remaining to the player.
	 */
	public int getWarriorStock() {
		return warriorStock;
	}
	/**
	 * gives the stock of food of the player.
     * @return the player's stock of food.
	 */
	public int getFoodStock() {
		return foodStock;
	}
	/**
     * increase the player's stock of warrior.
     * @param incr the value of the increment of the Player's warrior stock.
     */
	
	public void incrementWarriorStock(int incr) {
		
	}
	
	/**
	 * increase the player's stock of food.
     * @param incr the value of the increment of the Player's food stock.
     */
	public void incrementFoodStock(int incr) {
		
	}
	/**
     * decrease the player's stock of warrior.
     * @param decr the value of the decrement of the Player's warrior stock.
     */

	public void decrementWarriorStock(int decr) {
		
	}
	/**
	 * decrease the player's stock of food.
     * @param decr tthe value of the decrement of the Player's food stock.

	 */
	public void decrementFoodStock(int decr) {
		
	}
	
}