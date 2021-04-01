package game;
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
		// TODO
	}
	/**
	 * @see Action#execute(Board, Player)
	 * Make an unit deployment happens (and nothing more).
	 * 
	 * @param board the board where the unit will be
	 * deployed.
	 * @param player the player who is deploying the
	 * unit.
	 */
	@Override
	public void execute(Board board, Player player) {
		// TODO Auto-generated method stub

	}

}
