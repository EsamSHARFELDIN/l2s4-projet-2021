package game.player;

import java.util.*;

import game.Resource;
import game.action.Action;
import game.board.RandomBoard;
import game.exception.IllegalGameActionException;
import game.unit.Unit;

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
        this.units = new ArrayList<>();
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
    public abstract Action chooseAction(RandomBoard board);

    /**
     * Remunerate all units controlled by the player, and act appropriately if
     * a unit cannot be remunerated
     */
    public abstract void remunerateAll();

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
     * Return the score of the player
     * @return Player score
     */
    public abstract int score();

    /**
     * Collect the resources from the units controlled by the player
     */
    public void collectResources() throws IllegalGameActionException {
        for (Unit u : this.units) {
            Resource r = u.provideResource();
            switch (r) {
            case Stone:
                this.stoneStock++;
                break;
            case Sand:
                this.sandStock++;
                break;
            case Wheat:
                this.wheatStock++;
                break;
            case Wood:
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
     * tell if <code>unit</code> is controlled by this player.
     * @param unit an unit
     * @return <code>true</code> iff <code>unit</code> is 
     * controlled by this player.
     */
    public boolean hasUnit(Unit unit) {
    	return this.units.contains(unit);
    }

    /**
     * Get the player resource
     * @param resource
     * @return Amount of a particular resource type
     */
    public int getResource(Resource resource) {
        switch (resource) {
        case Stone:
            return this.stoneStock;
        case Sand:
            return this.sandStock;
        case Wheat:
            return this.wheatStock;
        case Wood:
            return this.woodStock;
        default:
            return -1;
        }
    }

    /**
     * Increase the player resource
     * @param i Amount
     * @param resource Type of resource
     */
    public void incrementResource(int i, Resource resource) {
        switch (resource) {
        case Stone:
            this.stoneStock += i;
            break;
        case Sand:
            this.sandStock += i;
            break;
        case Wheat:
            this.wheatStock += i;
            break;
        case Wood:
            this.woodStock += i;
            break;
        }
    }

    /**
     * Decrease the player resource
     * @param i Amount
     * @param resource Type of resource
     */
    public void decrementResource(int i, Resource resource) {
        switch (resource) {
        case Stone:
            this.stoneStock -= i;
            break;
        case Sand:
            this.sandStock -= i;
            break;
        case Wheat:
            this.wheatStock -= i;
            break;
        case Wood:
            this.woodStock -= i;
            break;
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

    /**
     * Return the name of the player
     * @return Player's name
     */
    public String getName() {
        return this.name;
    }

    public String summary() {
        return this.name + ": " +
            this.score() + " points, " +
            this.units.size() + " Un, " +
            this.goldStock + " Go, " +
            this.stoneStock + " St, " +
            this.sandStock + " Sa, " +
            this.wheatStock + " Wh, " +
            this.woodStock + " Wo, ";
    }

    public String toString() {
        return this.name;
    }
}
