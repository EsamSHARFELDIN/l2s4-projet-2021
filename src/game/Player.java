package game;

import java.util.*;

/**
 * this is abstract class, it used to represent a player.
 *
 *
 */
public abstract class Player {
    protected String name;
    /**
     * @param units the list of characters he controls.
     */
    protected List<Unit> units;
    protected int stoneStock;
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
    public Player(String name, int stoneStock, int sandStock, int wheatStock,
                  int woodStock, int goldStock) {

        this.name = name;
        this.units = new ArrayList<Unit>():
        this.stoneStock = stoneStock;
        this.sandStock = sandStock;
        this.wheatStock = wheatStock;
        this.woodStock = woodStock;
        this.goldStock = goldStock;
    }

    /**
     * Represent the action chosen by the player
     * @param board Playing board
     * @return an instance of a class implementing the Action.
     */
    public abstract Action chooseAction(Board board);

    /**
     * Allows the player to pay the cost of maintaining a unit
     * @param unit
     */
    public abstract void remunerate(Unit unit);

    /**
     * Indicate whether the resources of the player allow him to maintain one of
     * his units
     * @return <code>true</code> if the player can remunerate the unit, else
     * <code>false</code>
     */
    public abstract boolean canRemunerate(Unit unit);

    /**
     * Convert a player's resources into other resources
     */
    public abstract void convertResource();

    /**
     * Collect the resources from the units controlled by the player
     */
    public void collectResources() {
        for (Unit u : this.units) {
            Resource r = u.provideResource();
            switch (r) {
            case Resource.Stone:
                this.stoneStock++;
                break;
            case Resource.Sand:
                this.sandStock++;
                break;
            case Resource.Wheat:
                this.wheatStock++;
                break;
            case Resource.Wood:
                this.woodStock++;
                break;
            }
        }
    }

    /**
     * Add a unit to the player stock
     * @param unit a unit
     */
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    /**
     * Remove a unit from the player stock
     * @param unit
     */
    public void removeUnit(Unit unit) {
        this.units.remove(unit);
    }

    /**
     * Get the player resource
     * @param resource
     * @return Amount of a particular resource type
     */
    public int getResource(Resource resource) {
        switch (r) {
        case Resource.Stone:
            return this.stoneStock;
        case Resource.Sand:
            return this.sandStock;
        case Resource.Wheat:
            return this.wheatStock;
        case Resource.Wood:
            return this.woodStock;
        }
    }

    /**
     * Increase the player resource
     * @param i Amount
     * @param resource Type of resource
     */
    public void incrementResource(int i, Resource resource) {
        switch (r) {
        case Resource.Stone:
            this.stoneStock += i;
        case Resource.Sand:
            this.sandStock += i;
        case Resource.Wheat:
            this.wheatStock += i;
        case Resource.Wood:
            this.woodStock += i;
        }
    }

    /**
     * Decrease the player resource
     * @param i Amount
     * @param resource Type of resource
     */
    public void decrementResource(int i, Resource resource) {
        switch (r) {
        case Resource.Stone:
            this.stoneStock -= i;
        case Resource.Sand:
            this.sandStock -= i;
        case Resource.Wheat:
            this.wheatStock -= i;
        case Resource.Wood:
            this.woodStock -= i;
        }
    }

    /**
     * Return the amount of gold the player has
     * @return the player's quantity of gold
     */
    public int getGold() {
        return this.goldStock;
    }

    /**
     * Give a quantity of gold to the player
     * @param i A quantity of gold which will be added
     */
    public void incrementGold(int i) {
        this.goldStock += i;
    }

    /**
     * Remove a quantity of gold to the player
     * @param i a quantity of gold which will be withdrawn
     */
    public void decrementGold(int i) {
        this.goldStock -= i;
    }
}
