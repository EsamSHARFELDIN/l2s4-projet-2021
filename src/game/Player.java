package game;

import java.util.List;

/**
 * this is abstract class, it used to represent a player.
 *
 *
 */
public abstract class Player {
    protected String name;
    /**
     * @param theUnits the list of characters he controls.
     */
    protected List<Unit> units;
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
    public Player(String name, int rockStock, int sandStock, int wheatStock,
                  int woodStock, int goldStock) {

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
    public abstract Action chooseAction();

    /**
     * to collect the resources owned by the player.
     */
    public void collectResources() {

    }

    /**
     * to add a unit in the player stock.
     * @param unit a unit
     */
    public void addUnit(Unit unit) {

    }

    /**
     * to remove a unit in the player stock.
     * @param unit
     */
    public void removeUnit(Unit unit) {

    }

    /**
     *  allows the player to pay the cost of maintaining a unit.
     * @param unit
     */
    public abstract void remunerate(Unit unit);

    /**
     * to know if the resources of the player allow him to maintain one of his units.
     * @return
     */
    public abstract boolean canRemunerate();

    /**
     * is an abstract method, to converting a player's resources into other resources.
     */
    public abstract void convertResource();

    /**
     * to get the player resource.
     * @param resource
     * @return
     */
    public int getResource(Resource resource) {
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

    /** to give the Player's quantity
     * @return the Player's quantity of gold
     */
    public int getGold() {
        return 0;
    }

    /** to give a quantity of gold to the player
     * @param i a quantity of gold which will be added
     */
    public void incrementGold(int i) {

    }

    /** to remove a quantity of gold to the player
     * @param i a quantity of gold which will be withdrawn
     */
    public void decrementGold(int i) {

    }
}
