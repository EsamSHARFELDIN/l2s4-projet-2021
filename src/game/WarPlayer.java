package game;

import java.lang.Math;
import java.util.*;

/**
 * This class modelize a Player of a war game.
 * This class extends the Unit class (@see Player).
 */
public class WarPlayer extends Player {
    private static final int INITIAL_WARRIORS = 35;
    private static final int INITIAL_FOOD = 10;
    private static final int INITIAL_GOLD = 0;

    /**
     * the player's stock of warrior (35 at the start).
     */
    protected int warriorStock;

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
        super(name, 0, 0, 0, 0, INITIAL_GOLD);
        this.warriorStock = INITIAL_WARRIORS;
        this.foodStock = INITIAL_FOOD;
    }

    public void addUnit(Unit unit) {
        if (unit instanceof Army) {
            super.addUnit(unit);
            this.decrementWarriorStock(unit.getSize());
        }
        else {
            throw new RuntimeException("Tried to add a wrong unit");
        }
    }

    public void removeUnit(Unit unit) {
        if (unit instanceof Army) {
            super.removeUnit(unit);
        }
        else {
            throw new RuntimeException("Tried to remove a wrong unit");
        }
    }

    /**
     * Return an action among those specific to the war game
     * @param board Playing board
     * @return Action specific to the war game
     */
    public Action chooseAction(Board board) {
        double actionRoll = Math.random();
        if (this.warriorStock == 0 || actionRoll <= 0.5) {
            return new DoNothingAction();
        }
        else {
            List<Tile> freeTiles = board.freeTiles();
            Tile deploymentTile = freeTiles.get((int) (Math.random() * freeTiles.size()));
            double sizeRoll = Math.random();
            int size = (int) (sizeRoll * Math.min(deploymentTile.getMaxArmySize(),
                                                  this.warriorStock) + 1);
            Unit army = new Army(deploymentTile, size);
            return new WarDeployAction(deploymentTile.getX(), deploymentTile.getY(), army);
        }
    }

    /**
     * Remunerate the armies of the player (in the order they were created). If
     * there is no food to remunerate an army, it is destroyed and the player
     * loses control of the previously occupied tile, but gets one gold back
     */
    public void remunerateAll() {
        for (Unit unit : this.units) {
            if (this.canRemunerate(unit)) {
                this.remunerate(unit);
            }
            else {
                this.removeUnit(unit);
                unit.destroy();
                this.goldStock++;
            }
        }
    }

    /**
     * Pay the maintenance cost of the unit
     * @param unit Unit to feed
     */
    public void remunerate(Unit unit) {
        decrementFoodStock(unit.cost());
    }

    /**
     * Return <code>true</code> if the player has the resources to pay the
     * maintenance cost of the unit, else <code>false</code>
     * @return A boolean indicating if the player can feed the unit
     */
    public boolean canRemunerate(Unit unit) {
        return (unit.cost() <= this.foodStock);
    }

    /**
     * convert the player's resource in food.
     */
    @Override
    public void convertResource() {
        incrementFoodStock(this.stoneStock * Resource.getConversionValue(Resource.Stone));
        this.stoneStock = 0;
        incrementFoodStock(this.sandStock * Resource.getConversionValue(Resource.Sand));
        this.sandStock = 0;
        incrementFoodStock(this.wheatStock * Resource.getConversionValue(Resource.Wheat));
        this.wheatStock = 0;
        incrementFoodStock(this.woodStock * Resource.getConversionValue(Resource.Wood));
        this.woodStock = 0;
    }

    /**
     * gives the number of warriors remaining to the player.
     * @return the number of warriors remaining to the player.
     */
    public int getWarriorStock() {
        return this.warriorStock;
    }

    /**
     * gives the stock of food of the player.
     * @return the player's stock of food.
     */
    public int getFoodStock() {
        return this.foodStock;
    }

    /**
     * increase the player's stock of warrior.
     * @param incr the value of the increment of the Player's warrior stock.
     */
    public void incrementWarriorStock(int incr) {
        this.warriorStock += incr;
    }

    /**
     * increase the player's stock of food.
     * @param incr the value of the increment of the Player's food stock.
     */
    public void incrementFoodStock(int incr) {
        this.foodStock += incr;
    }

    /**
     * decrease the player's stock of warrior.
     * @param decr the value of the decrement of the Player's warrior stock.
     */
    public void decrementWarriorStock(int decr) {
        this.warriorStock -= decr;
    }

    /**
     * decrease the player's stock of food.
     * @param decr the value of the decrement of the Player's food stock.

     */
    public void decrementFoodStock(int decr) {
        this.foodStock -= decr;
    }
}
