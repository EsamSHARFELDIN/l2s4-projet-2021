package game.action;

import java.util.*;

import game.board.Board;
import game.exception.GameException;
import game.player.Player;
import game.tile.OceanTile;
import game.tile.Tile;
import game.unit.Army;
import game.unit.Unit;

/**
 * A class which represents the specific consequences of deploying a unit on
 * a game tile in the war game. The deployment has military consequences on the
 * surrounding tiles and on the occupying units, such as tile conquest and army
 * capture
 */
public class WarDeployAction extends DeployAction {
    /**
     * Construct a deployment action specific to the war game, for a specified
     * tile and a specified unit
     * @param x Horizontal coordinate of the tile
     * @param y Vertical coordinate of the tile
     * @param u Deployed unit. Must be an instance of class Army
     */
    public WarDeployAction(int x, int y, Unit u) {
        super(x, y, u);
    }

    /**
     * Return <code>true</code> if the deployment on deploymentTile triggers a
     * reaction on adjacentTile, ie if the armies are allied and the size of the
     * army on adjacentTile is strictly inferior to the size of the army on
     * deploymentTile, or if the armies are enemies and the military strength of
     * the army on adjacentTile is strictly inferior to the military strength
     * of the army on deploymentTile, else return <code>false</code>
     * @param adjacentTile Tile next to the tile where a new army is deployed
     * @param deploymentTile Tile where the army is deployed
     * @return <code>true</code> iff the deployment triggers a reaction
     */
    private boolean triggersReaction(Tile adjacentTile, Tile deploymentTile) {
        if (!(adjacentTile instanceof OceanTile) && adjacentTile.isBusy()) {
            if (isAllied(adjacentTile, deploymentTile.getUnit().getPlayer())) {
                return ((Army) adjacentTile.getUnit()).getSize() <
                    ((Army) deploymentTile.getUnit()).getSize();
            }
            else {
                return ((Army) adjacentTile.getUnit()).militaryStrength() <
                    ((Army) deploymentTile.getUnit()).militaryStrength();
            }
        }
        return false;
    }

    /**
     * Return <code>true</code> if the tile belongs to the player
     * @param tile Tile to check. Must be occupied by a unit
     * @param player Player to compare to the player occupying the tile
     * @return Indication on the ally status of the tile and player
     */
    private boolean isAllied(Tile tile, Player player) {
        return (tile.getUnit().getPlayer() == player);
    }

    /**
     * Performs the operations corresponding to the effect of a deployment next
     * to an allied army. The size of the allied army is increased by 1 and the
     * deployed army receives 1 gold. Also prints a trace message to stdout
     * @param adjacentTile Tile next to the tile where a new army is deployed.
     * Must be occupied by a unit
     * @param deploymentTile Tile where the army is deployed
     */
    private void allyEffect(Tile adjacentTile, Tile deploymentTile) {
        System.out.println(allyEffectTrace(adjacentTile, deploymentTile));
        /* l'armée voisine augmente sa taille de 1 */
        ((Army) adjacentTile.getUnit()).incrementSize(1);
        /* +1 or pour l'unité déployée */
        deploymentTile.getUnit().receiveGold(1);
    }

    /**
     * Return a printable message for the effects of a deployment next to an
     * allied army
     * @param adjacentTile Tile next to the tile where a new army is deployed.
     * Must be occupied by a unit
     * @param deploymentTile Tile where the army is deployed
     * @return string representation of the effect
     */
    private String allyEffectTrace(Tile adjacentTile, Tile deploymentTile) {
        return "Size of neighbour " + adjacentTile.getUnit() +
            " on " + adjacentTile + " is increased by 1 and the unit deployed on " +
            deploymentTile + " gets 1 gold";
    }

    /**
     * Performs the operations corresponding to the effect of a deployment next
     * to an enemy army. If the strength of the enemy / 2 is less than 1, the
     * tile is conquered and the enemy army joins the units of the deploying
     * player (its size is not decreased). Else, its size is divided by 2. Also
     * prints a trace message to stdout
     * @param adjacentTile Tile next to the tile where a new army is deployed.
     * Must be occupied by a unit
     * @param deploymentTile Tile where the army is deployed
     */
    private void enemyEffect(Tile adjacentTile, Tile deploymentTile) {
        int halfStrength = ((Army) adjacentTile.getUnit()).militaryStrength() / 2;
        if (halfStrength < 1) {
            System.out.println(enemyEffectConquestTrace(adjacentTile, deploymentTile));
            /* ralliement */
            adjacentTile.getUnit().getPlayer().removeUnit(adjacentTile.getUnit());
            adjacentTile.getUnit().setPlayer(deploymentTile.getUnit().getPlayer());
            deploymentTile.getUnit().getPlayer().addUnit(adjacentTile.getUnit());
            /* +2 or pour l'unité déployée */
            deploymentTile.getUnit().receiveGold(2);
        }
        else {
            /* taille armée de la tuile voisine = ancienne taille / 2 */
            int size = ((Army) adjacentTile.getUnit()).getSize();
            int halfSize = size / 2;
            // ((Army) adjacentTile.getUnit()).incrementSize(halfSize - size);
            ((Army) adjacentTile.getUnit()).setSize(halfSize);
            /* TODO: simplifiable avec une méthode Army::setSize(int)... */
            System.out.println(enemyEffectNoConquestTrace(adjacentTile, deploymentTile,
                                                          halfSize));
        }
    }

    /**
     * Return a printable message for the effects of a deployment next to an
     * enemy army which is conquered
     * @param adjacentTile Tile next to the tile where a new army is deployed.
     * Must be occupied by a unit
     * @param deploymentTile Tile where the army is deployed
     * @return string representation of the effect
     */
    private String enemyEffectConquestTrace(Tile adjacentTile, Tile deploymentTile) {
        return adjacentTile.getUnit() + " on " + adjacentTile + " now belongs to " +
            deploymentTile.getUnit().getPlayer() + ", and the unit deployed on " +
            deploymentTile + " gets 2 gold";
    }

    /**
     * Return a printable message for the effects of a deployment next to an
     * enemy army which is not conquered
     * @param adjacentTile Tile next to the tile where a new army is deployed.
     * Must be occupied by a unit
     * @param deploymentTile Tile where the army is deployed
     * @param size New size of the enemy army
     * @return string representation of the effect
     */
    private String enemyEffectNoConquestTrace(Tile adjacentTile, Tile deploymentTile, int size) {
        return adjacentTile.getUnit() + " on " + adjacentTile +
            " now has size " + size;
    }

    /**
     * Execute the action: deploy the unit and proceed with the appropriate
     * military consequences on the surrounding tiles and units. For every unit
     * occupying a neighbour tile of the tile where the army is deployed:<br>
     * - if the army belongs to a different player than the deploying player,
     * and its military power is strictly inferior to the power of the deployed
     * army, and its military power divided by two is less than 1, then the army
     *  is conquered (but its size does not change), and the newly deployed army
     * gets 2 gold<br>
     * - if the army belongs to the deploying player and its size is strictly
     * inferior to the the size of the deployed army, then its size is increased
     * by 1 within the limits defined by the type of terrain, and the newly
     * deployed army gets 1 gold<br>
     * - if the army has a size superior or equal to that of the deployed army,
     * then nothing happens<br>
     * Units on the board must be instances of class Army exclusively
     *
     * @param board Playing board
     * @param player Player who is deploying the unit
     *
     * @see DeployAction#execute(Board, Player)
     */
    public void execute(Board board, Player player) throws GameException {
        super.execute(board, player);
        Tile deploymentTile = board.tileAt(this.x, this.y);
        List<Tile> adjacent = board.adjacentTiles(this.x, this.y);
        boolean noEffect = true;
        for (Tile tile : adjacent) {
            if (triggersReaction(tile, deploymentTile)) {
                noEffect = false;
                System.out.println("Effects on " + tile + ":");
                if (isAllied(tile, player)) {
                    allyEffect(tile, deploymentTile);
                }
                else {
                    enemyEffect(tile, deploymentTile);
                }
            }
        }
        if (noEffect) {
            System.out.println("No effect on surrounding tiles");
        }
    }
}
