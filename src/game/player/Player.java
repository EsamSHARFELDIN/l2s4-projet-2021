package game.player;

import java.util.*;

import game.Resource;
import game.action.Action;
import game.board.Board;
import game.board.RandomBoard;
import game.exception.IllegalGameActionException;
import game.unit.Unit;

/**
 * This is abstract class, it used to represent a player.
 */
public abstract class Player {
    /** Name of the player */
    protected String name;

    /** List of units the player controls */
    protected List<Unit> units;

    /** Amount of stone in the player's stocks */
    protected int stoneStock;

    /** Amount of sand in the player's stocks */
    protected int sandStock;

    /** Amount of wheat in the player's stocks */
    protected int wheatStock;

    /** Amount of wood in the player's stocks */
    protected int woodStock;

    /** Amount of gold in the player's stocks */
    protected int goldStock;

    /**
     * Current score of the player, set at construction and at the end of every
     * turn
     */
    protected int currentScore;

    /**
     * Create a new player with the given arguments.
     *
     * @param name the name of the player
     * @param stoneStock initial value of the stone stock.
     * @param sandStock initial value of the sand stock.
     * @param wheatStock initial value of the wheat stock.
     * @param woodStock initial value of the wood stock.
     * @param goldStock initial value of the gold stock.
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
        this.currentScore = this.score();
    }

    /**
     * Represent the action chosen by the player
     * @param board Playing board
     * @return an instance of a class implementing the Action.
     */
    public abstract Action chooseAction(Board board);

    /**
     * Remunerate all units controlled by the player, and act appropriately if
     * a unit cannot be remunerated
     */
    public abstract void remunerateAll();

    /**
     * Allows the player to pay the cost of maintaining a unit
     * @param unit Unit to remunerate
     */
    public abstract void remunerate(Unit unit);

    /**
     * Indicate whether the resources of the player allow him to maintain one of
     * his units
     * @param unit Unit to check
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
     * @throws IllegalGameActionException if a unit occupies a tile which does
     * not produce resources
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
     * @param unit Unit to add
     */
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    /**
     * Remove a unit from the player stock
     * @param unit Unit to remove
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
     * @param resource Type of resource to retrieve
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
     * @param i Amount to add to the stock of given resource
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
     * @param i Amount to substract from the stock of resource
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

    /**
     * Return a string representation of the state of a player, containing
     * their name, score, number of units, and amount of different resources
     * possessed
     * @return String representation of a player
     */
    public String summary() {
        int previousScore = this.currentScore;
        this.currentScore = this.score();
        int diff = this.currentScore - previousScore;
        return this.name + ": " +
            this.currentScore + " points " +
            "(" + ((diff >= 0) ? "+" + diff : diff) + "), " +
            this.units.size() + " Un, " +
            this.goldStock + " Go, " +
            this.stoneStock + " St, " +
            this.sandStock + " Sa, " +
            this.wheatStock + " Wh, " +
            this.woodStock + " Wo, ";
    }

    /**
     * Return a basic string representation of the player, consisting of their
     * name
     * @return Name of a player
     */
    public String toString() {
        return this.name;
    }
}
