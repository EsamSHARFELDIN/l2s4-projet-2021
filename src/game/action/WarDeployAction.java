package game.action;

import java.util.*;

import game.Army;
import game.Board;
import game.GameException;
import game.OceanTile;
import game.Player;
import game.Tile;
import game.Unit;

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
        /* effet si la tuile voisine est une tuile terrestre occupée, et que la
         * puissance de l'armée qui l'occupe est strictement inférieure à la
         * puissance de l'armée déployée */
        return (!(adjacentTile instanceof OceanTile) &&
                adjacentTile.isBusy() &&
                (((Army) adjacentTile.getUnit()).militaryStrength() <
                 ((Army) deploymentTile.getUnit()).militaryStrength()));
    }

    private boolean isAllied(Tile tile, Player player) {
        return (tile.getUnit().getPlayer() == player);
    }

    private void allyEffect(Tile adjacentTile, Tile deploymentTile) {
        /* l'armée voisine augmente sa taille de 1 */
        ((Army) adjacentTile.getUnit()).incrementSize(1);
        /* +1 or pour l'unité déployée */
        deploymentTile.getUnit().receiveGold(1);
    }

    private void enemyEffect(Tile adjacentTile, Tile deploymentTile) {
        int halfStrength = ((Army) adjacentTile.getUnit()).militaryStrength() / 2;
        if (halfStrength < 1) {
            /* ralliement */
            adjacentTile.getUnit().setPlayer(deploymentTile.getUnit().getPlayer());
            /* +2 or pour l'unité déployée */
            deploymentTile.getUnit().receiveGold(2);
        }
        else {
            /* taille armée de la tuile voisine = ancienne taille / 2 */
            int size = ((Army) adjacentTile.getUnit()).getSize();
            int halfSize = size / 2;
            ((Army) adjacentTile.getUnit()).incrementSize(halfSize - size);
            /* TODO: simplifiable avec une méthode Army::setSize(int)... */
        }
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
        super.execute(board, player);
        Tile deploymentTile = board.tileAt(this.x, this.y);
        List<Tile> adjacent = board.adjacentTiles(this.x, this.y);
        for (Tile tile : adjacent) {
            if (triggersReaction(tile, deploymentTile)) {
                if (isAllied(tile, player)) {
                    allyEffect(tile, deploymentTile);
                }
                else {
                    enemyEffect(tile, deploymentTile);
                }
            }
        }
    }
}
