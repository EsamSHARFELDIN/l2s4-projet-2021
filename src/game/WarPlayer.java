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
     * Create a player for the war game with given name.
     *
     * Initially the player has 35 warriors, 10 food unit and 0 gold coin.
     * @param name name of this player.
     */
    public WarPlayer(String name) {
        super("Foo", 0, 0, 0, 0, 0);
    }

    /**
     * Return an action among those specific to the war game
     * @return Action specific to the war game
     */
    public Action chooseAction() {

    }

    /**
     * Pay the maintenance cost of the unit
     * @param unit Unit to feed
     */
    public void remunerate(Unit unit) {

    }

    /**
     * Return <code>true</code> if the player has the resources to pay the
     * maintenance cost of the unit, else <code>false</code>
     * @return A boolean indicating if the player can feed the unit
     */
    public boolean canRemunerate() {

    }

    /**
     * convert the player's resource in food.
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
     * @param decr the value of the decrement of the Player's food stock.

     */
    public void decrementFoodStock(int decr) {

    }
}
