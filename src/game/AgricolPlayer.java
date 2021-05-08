package game;

import java.lang.Math;
import java.util.*;

/**
 * This class modelize a Player of an agricol game.
 * This class extends the Unit class (@see Player).
 */
public class AgricolPlayer extends Player {
    private static final int INITIAL_GOLD = 15;

    /**
     * create a player for the agricol game with the given name.
     *
     * Initially, this player has 15 gold coin and no ressources.
     * @param name name of this player
     */
    public AgricolPlayer(String name) {
        super(name, 0, 0, 0, 0, INITIAL_GOLD);
    }

    public void addUnit(Unit unit) {
        if (unit instanceof Worker) {
            super.addUnit(unit);
        }
        else {
            throw new RuntimeException("Tried to add a wrong unit");
        }
    }

    public void removeUnit(Unit unit) {
        if (unit instanceof Worker) {
            super.removeUnit(unit);
        }
        else {
            throw new RuntimeException("Tried to remove a wrong unit");
        }
    }

    /**
     * Return an action among those specific to the agricultural game
     * @param board Playing board
     * @return Action specific to the agricultural game
     */
    public Action chooseAction(Board board) {
        double roll = Math.random();
        if (roll <= 0.33) {
            List<Tile> freeTiles = board.freeTiles();
            Tile deploymentTile = freeTiles.get((int) (Math.random() * freeTiles.size()));
            Unit worker = new Worker(deploymentTile);
            return new DeployAction(deploymentTile.getX(), deploymentTile.getY(), worker);
        }
        else if (roll <= 0.66) {
            return new AgricolDoNothingAction();
        }
        else {
            return new AgricolExchangeAction();
        }
    }

    /**
     * Remunerate the workers of the player (in the order they were created).
     * If there is no food to remunerate a worker, it is destroyed and the
     * player loses control of the previously occupied tile
     */
    public void remunerateAll() {
        for (Unit unit : this.units) {
            if (this.canRemunerate(unit)) {
                this.remunerate(unit);
            }
            else {
                unit.destroy();
            }
        }
    }

    /**
     * Pay the maintenance cost of the unit
     * @param unit Unit to feed
     */
    public void remunerate(Unit unit) {
        decrementGold(unit.cost());
    }

    /**
     * Return <code>true</code> if the player has the resources to pay the
     * maintenance cost of the unit, else <code>false</code>
     * @return A boolean indicating if the player can feed the unit
     */
    public boolean canRemunerate(Unit unit) {
        return (unit.cost() <= this.goldStock);
    }

    /**
     * convert the player's resource in gold.
     */
    @Override
    public void convertResource() {
        incrementGold(this.stoneStock * Resource.getConversionValue(Resource.Stone));
        this.stoneStock = 0;
        incrementGold(this.sandStock * Resource.getConversionValue(Resource.Sand));
        this.sandStock = 0;
        incrementGold(this.wheatStock * Resource.getConversionValue(Resource.Wheat));
        this.wheatStock = 0;
        incrementGold(this.woodStock * Resource.getConversionValue(Resource.Wood));
        this.woodStock = 0;
    }

    /**
     * Return the score of the player, ie the sum of the gold owned by the
     * controlled workers
     * @return Player score
     */
    public int score() {
        int score = 0;
        for (Unit unit : this.units) {
            score += unit.points();
        }
        return score;
    }

    /**
     * Collect gold from the units when the player chooses to do nothing for
     * a turn
     */
    public void collectIdleGold() {
        /* Downcasting should be safe here, because of the type check in addUnit */
        for (Unit u : this.units) {
            incrementGold(((Worker) u).goldcoinWhenplayerDoesNothing());
        }
    }
}
