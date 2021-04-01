package game;

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
        // TODO
    }

    /**
     * @see DeployAction#execute(Board, Player)
     * Execute the action: deploy the unit and proceed with the appropriate
     * military consequences on the surrounding tiles and units. The details of
     * the rules can be found in the specification document
     * @param board Playing board
     * @param player Player who is deploying the unit
     */
    public void execute(Board board, Player player) {
        // TODO
    }
}
