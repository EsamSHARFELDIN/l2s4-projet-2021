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
 * @version 01/04/21
 */
public class WarDeployAction extends DeployAction {
    /**
     * Construct a deployment action specific to the war game, for a specified
     * tile and a specified unit
     * @param x Horizontal coordinate of the tile
     * @param y Vertical coordinate of the tile
     * @param u Deployed unit
     */
    public WarDeployAction(int x, int y, Unit u) {
        super(x, y, u);
    }

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

    private boolean isAllied(Tile tile, Player player) {
        return (tile.getUnit().getPlayer() == player);
    }

    private void allyEffect(Tile adjacentTile, Tile deploymentTile) {
        System.out.println(allyEffectTrace(adjacentTile, deploymentTile));
        /* l'armée voisine augmente sa taille de 1 */
        ((Army) adjacentTile.getUnit()).incrementSize(1);
        /* +1 or pour l'unité déployée */
        deploymentTile.getUnit().receiveGold(1);
    }

    private String allyEffectTrace(Tile adjacentTile, Tile deploymentTile) {
        return "Size of neighbour " + adjacentTile.getUnit() +
            " on " + adjacentTile + " is increased by 1 and the unit deployed on " +
            deploymentTile + " gets 1 gold";
    }

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

    private String enemyEffectConquestTrace(Tile adjacentTile, Tile deploymentTile) {
        return adjacentTile.getUnit() + " on " + adjacentTile + " now belongs to " +
            deploymentTile.getUnit().getPlayer() + ", and the unit deployed on " +
            deploymentTile + " gets 2 gold";
    }

    private String enemyEffectNoConquestTrace(Tile adjacentTile, Tile deploymentTile, int size) {
        return adjacentTile.getUnit() + " on " + adjacentTile +
            " now has size " + size;
    }

    /**
     * @see DeployAction#execute(Board, Player)
     * Execute the action: deploy the unit and proceed with the appropriate
     * military consequences on the surrounding tiles and units. The details of
     * the rules can be found in the specification document
     * @param board Playing board
     * @param player Player who is deploying the unit
     */
    public void execute(Board board, Player player) throws GameException {
        System.out.println("WARDEPLOYACTION::EXECUTE called");
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
