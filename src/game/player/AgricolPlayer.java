package game.player;

import java.lang.Math;
import java.util.*;

import game.Resource;
import game.action.Action;
import game.action.AgricolDoNothingAction;
import game.action.AgricolExchangeAction;
import game.action.DeployAction;
import game.board.Board;
import game.tile.Tile;
import game.unit.Unit;
import game.unit.Worker;

/**
 * This class model a Player of an agricol game.
 * This class extends the Player class
 * @see Player
 */
public class AgricolPlayer extends Player {
    /** Initial amount of gold */
    private static final int INITIAL_GOLD = 15;

    /**
     * Create a player for the agricol game with the given name.
     *
     * Initially, this player has 15 gold coin and no resources.
     * @param name name of this player
     */
    public AgricolPlayer(String name) {
        super(name, 0, 0, 0, 0, INITIAL_GOLD);
    }

    /**
     * Add a unit to the units of a player
     * @param unit Unit to add. Must be an instance of class Worker
     * @throws RuntimeException if the unit is not an instance of Worker
     */
    public void addUnit(Unit unit) {
        if (unit instanceof Worker) {
            super.addUnit(unit);
        }
        else {
            throw new RuntimeException("Tried to add a wrong unit");
        }
    }

    /**
     * Remove a unit from the units of a player
     * @param unit Unit to remove. Must be an instance of class Worker
     * @throws RuntimeException if the unit is not an instance of Worker
     */
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
        Iterator<Unit> it = this.units.listIterator();
        while (it.hasNext()) {
            Unit unit = it.next();
            if (this.canRemunerate(unit)) {
                System.out.println(canRemunerateTrace(unit));
                this.remunerate(unit);
            }
            else {
                System.out.println(cannotRemunerateTrace(unit));
                it.remove();
                unit.destroy();
            }
        }
    }

    /**
     * Return a printable message to indicate that the player is able to pay the
     * maintenance cost of a unit
     * @param unit Maintained unit
     * @return String representation of the fact that a unit can be paid
     */
    private String canRemunerateTrace(Unit unit) {
        return this.toString() + " remunerates " + unit + " on " + unit.getTile() +
            " with " + unit.cost() + " gold";
    }

    /**
     * Return a printable message to indicate that the player is unable to pay
     * the maintenance cost of a unit
     * @param unit Maintained unit
     * @return String representation of the fact that a unit cannot be paid
     */
    private String cannotRemunerateTrace(Unit unit) {
        return this.toString() + " loses " + unit + " costing " + unit.cost() +
            " gold on " + unit.getTile();
    }

    /**
     * Pay the maintenance cost of the unit
     * @param unit Unit to feed
     */
    public void remunerate(Unit unit) {
        int unitCost = unit.cost();
        decrementGold(unitCost);
        unit.receiveGold(unitCost);
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
        System.out.println(convertTrace());
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
     * Return a printable message to the conversion which would be performed if
     * convertResource was called
     * @return String representation of the resource conversion
     */
    private String convertTrace() {
        return this.toString() + " converts\n" +
            this.stoneStock + " Stone into " +
            this.stoneStock * Resource.getConversionValue(Resource.Stone) + " gold\n" +
            this.sandStock + " Sand into " +
            this.sandStock * Resource.getConversionValue(Resource.Sand) + " gold\n" +
            this.wheatStock + " Wheat into " +
            this.wheatStock * Resource.getConversionValue(Resource.Wheat) + " gold\n" +
            this.woodStock + " Wood into " +
            this.woodStock * Resource.getConversionValue(Resource.Wood) + " gold";
    }

    /**
     * Return the score of the player, i.e the sum of the gold owned by the
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

    /**
     * Return a string representation of the specific resources of an
     * AgricolPlayer
     * @return String representation
     */
    public String summary() {
        return super.summary();
    }
}
