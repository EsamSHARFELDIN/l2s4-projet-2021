package game;

/**
 * This class modelize a Player of an agricol game.
 * This class extends the Unit class (@see Player).
 */
public class AgricolPlayer extends Player {

    /**
     * create a player for the agricol game with the given name.
     *
     * Initially, this player has 15 gold coin and no ressources.
     * @param name name of this player
     */
    public AgricolPlayer(String name) {
        super("Bar", 0, 0, 0, 0, 0);
    }

    /**
     * Return an action among those specific to the agricultural game
     * @return Action specific to the agricultural game
     */
    public Action chooseAction() {

    }

    /**
     * Pay the maintenance cost of the unit
     * @param unit Unit to feed
     */
    public void remunerate(Unit unit) {

    }

    /**
     * Return <code>true</code> if the player has the resources to pay the
     * maintenance cost of the unit, else <code>false</code>
     * @return A boolean indicating if the player can feed the unit
     */
    public boolean canRemunerate() {

    }

    /**
     * convert the player's resource in gold.
     */
    @Override
    public void convertResource() {

    }
}
