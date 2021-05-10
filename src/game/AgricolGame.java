package game;
import game.*;

import java.util.*;

/**
 * A class which allows to model the war game.
 */

public class AgricolGame extends Game {
    private static int MAX_TURNS = 6;

    protected int turns_counter;

    /**
     * Creates an agricol game with a board of given dimensions
     * @param width Width of the board to use
     * @param height Height of the board to use
     */
    public AgricolGame(int width, int height) {
      super(width, height);
      this.turns_counter = 0;
      initialize();
    }

    /**
     * initializes a new agricol game.
     */
    private void initialize() {
      Resource.setConversionValue(Resource.Stone, 8);
      Resource.setConversionValue(Resource.Sand, 5);
      Resource.setConversionValue(Resource.Wood, 2);
      Resource.setConversionValue(Resource.Wheat, 2);

      PlainTile.MAX_ARMY_SIZE = 1;
      PlainTile.ADDITIONAL_POWER = 0;
      PlainTile.ADDITIONAL_POINTS = 0;
      PlainTile.GOLD_WHEN_DOING_NOTHING = 1;
      PlainTile.COST_ADD = 1;
      PlainTile.COST_FACTOR = 1;

      MountainTile.MAX_ARMY_SIZE = 1;
      MountainTile.ADDITIONAL_POWER = 0;
      MountainTile.ADDITIONAL_POINTS = 0;
      MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
      MountainTile.COST_ADD = 5;
      MountainTile.COST_FACTOR = 1;

      ForestTile.MAX_ARMY_SIZE = 1;
      ForestTile.ADDITIONAL_POWER = 0;
      ForestTile.ADDITIONAL_POINTS = 0;
      ForestTile.GOLD_WHEN_DOING_NOTHING = 1;
      ForestTile.COST_ADD = 1;
      ForestTile.COST_FACTOR = 1;

      DesertTile.MAX_ARMY_SIZE = 1;
      DesertTile.ADDITIONAL_POWER = 0;
      DesertTile.ADDITIONAL_POINTS = 0;
      DesertTile.GOLD_WHEN_DOING_NOTHING = 2;
      DesertTile.COST_ADD = 3;
      DesertTile.COST_FACTOR = 1;

      /*
      MAX_ARMY_SIZE;
      ADDITIONAL_POWER
      ADDITIONAL_POINTS
      GOLD_WHEN_DOING_NOTHING
      COST_ADD
      COST_FACTOR
      */
    }

    /**
     * Start the agricol game and give the course of the game.
     * @return Player the winner of the game.
     */
    @Override
    public Player play() throws GameException {
      if (this.players.isEmpty()) {
        throw new RuntimeException("Tried to play with no players");
      }
      /* Initialiser itérateur au début de la liste des joueurs */
      Iterator<Player> it = this.players.listIterator();

      Player p = null;
      while (!this.isGameOver()) {
        if (it.hasNext()) {
          p = it.next();
        }
        else {
          it = this.players.listIterator();
          p = it.next();
          this.turns_counter++;
        }
        /* réaliser une action */
        Action action = p.chooseAction(this.board);
        action.execute(this.board, p);
        /* rémunérer les unités */
        p.remunerateAll();
      }

      /* trouver le joueur au score maximal et le renvoyer */
      p = this.players.get(0);
      for (Player player : this.players) {
        if (player.score() > p.score()) {
          p = player;
        }
      }
      return p;
    }

    protected boolean isGameOver() {
      return (this.board.isFull() || this.turns_counter == MAX_TURNS);
    }
}
