//package foo TO DO

/**
 * This class modelize a Player of a war game.
 * This class extends the Unit class (@see Player).
 */

public class WarPlayer extends Player {

    /**
     * The player's stock of warrior (35 at the start).
     */
    protected int warriorStock = 35;

    /**
     * The player's stock of food.
     */
    protected int foodStock;
    
    /**
     * create a Player with given name.
     * @param name the name of the Player. 
     */
    public warPlayer(String name){

    }

    /**
     * convert the player's ressource in food.
     */
    @Override
    public void convertResource(){

    }

    /**
     * gives the number of warriors remaining to the player.
     * @return the number of warriors remaining to the player.
     */
    public int getWarriorStock(){

    }

    /**
     * gives the stock of food of the player.
     * @return the player's stock of food.
     */
    public int getFoodStock(){

    }

    /**
     * increase the player's stock of warrior.
     * @param incr the value of the increment of the Player's warrior stock.
     */
    public void incrementWarriorStock(int incr){

    }

    /**
     * decrease the player's stock of warrior.
     * @param decr the value of the decrement of the Player's warrior stock.
     */
    public void decrementWarriorStock(int decr){

    }

    /**
     * increase the player's stock of food.
     * @param incr the value of the increment of the Player's food stock.
     */
    public void incrementFoodStock(int incr){

    }

    /**
     * decrease the player's stock of food.
     * @param decr tthe value of the decrement of the Player's food stock.
     */
    public void decrementFoodStock(int decr){

    }


}
