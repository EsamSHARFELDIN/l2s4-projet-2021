package game.action;

import game.board.Board;
import game.exception.GameException;
import game.exception.IllegalGameActionException;
import game.exception.UnknownTileException;
import game.player.Player;
import game.tile.Tile;
import game.unit.Unit;

/**
 * A class modeling the action of deploying a unit 
 * (on the board) in the game. Then, if a player 
 * wants to deploy an unit, he must instance this 
 * class (or its subclass) with the needed arguments.
 * This class does not handle the eventual consequences
 * of the deployment depending on the current rules of 
 * the game but simply deploy an unit. Then, a deployment
 * with some consequences should be a subclass of this 
 * class and these consequences will be handled in the 
 * subclass.
 */
public class DeployAction implements Action {
	
	protected int x;
	protected int y;
	protected Unit u;
	
	/**
	 * creating (preparing) an action of deploying
	 * the given unit on the board on the given
	 * coordinates (x, y)
	 * 
	 * @param x the abscissa of the coordinates
	 * @param y ordinate of the coordinates
	 * @param u the unit to deploy
	 */
	public DeployAction(int x, int y, Unit u) {
		this.x = x;
		this.y = y;
		this.u = u;
	}
	/**
	 * @see Action#execute(Board, Player)
	 * Make an unit deployment happens (and nothing more). A trace is
         * printed to stdout
	 * 
	 * @param board the board where the unit will be
	 * deployed.
	 * @param player the player who is deploying the
	 * unit.
	 * @throws UnknownTileException when trying to deploy on a non-existing tile.
	 * @throws IllegalGameException when trying to deploy on a busy tile.
	 */
	@Override
	public void execute(Board board, Player player) throws GameException {
		Tile tile;
		try {
			tile = board.tileAt(this.x, this.y);
		} catch(UnknownTileException e) {
			throw new UnknownTileException ("Trying to set an unit on a "
					+ "non-existing tile: (" + this.x + ", "+ this.y + ")");
		}
		if (!tile.isBusy()) {
                        u.setPlayer(player);
			tile.setUnit(u);
                        u.setTile(tile);
			player.addUnit(u);
                        System.out.println(this.trace(player, tile));
		}
		else {
			throw new IllegalGameActionException("Trying to set an unit on "
					+ "a busy tile: (" + this.x + ", "+ this.y + ")");
		}
	}

    /**
     * Return a printable message representing the deployment action
     * @param player Player deploying a unit
     * @param tile Tile where the unit is deployed
     * @return String representation of the action
     */
    private String trace(Player player, Tile tile) {
        return player + " deploys " + this.u + " at " + tile;
    }
}
