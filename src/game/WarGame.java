package game;

import java.util.*;

/**
 * A class which allows to model the war game.
 */
public class WarGame extends Game {
    private static int MAX_TURNS = 10;

    protected int turns_counter;

    /**
     * Creates a war game with a board of given dimensions
     * @param width Width of the board to use
     * @param height Height of the board to use
     */
    public WarGame(int width, int height){
        super(width, height);
        this.turns_counter = 0;
        initialize();
    }

    /**
     * initializes a new war game.
     */
    private void initialize(){
        Resource.setConversionValue(Resource.Stone, 0);
        Resource.setConversionValue(Resource.Sand, 0);
        Resource.setConversionValue(Resource.Wood, 1);
        Resource.setConversionValue(Resource.Wheat, 5);

        PlainTile.MAX_ARMY_SIZE = 5;
        PlainTile.ADDITIONAL_POWER = 0;
        PlainTile.ADDITIONAL_POINTS = 1;
        PlainTile.GOLD_WHEN_DOING_NOTHING = 0;
        PlainTile.COST_ADD = 0;
        PlainTile.COST_FACTOR = 1;

        MountainTile.MAX_ARMY_SIZE = 3;
        MountainTile.ADDITIONAL_POWER = 2;
        MountainTile.ADDITIONAL_POINTS = 4;
        MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
        MountainTile.COST_ADD = 0;
        MountainTile.COST_FACTOR = 1;

        ForestTile.MAX_ARMY_SIZE = 5;
        ForestTile.ADDITIONAL_POWER = 0;
        ForestTile.ADDITIONAL_POINTS = 2;
        ForestTile.GOLD_WHEN_DOING_NOTHING = 0;
        ForestTile.COST_ADD = 0;
        ForestTile.COST_FACTOR = 1;

        DesertTile.MAX_ARMY_SIZE = 3;
        DesertTile.ADDITIONAL_POWER = 0;
        DesertTile.ADDITIONAL_POINTS = 4;
        DesertTile.GOLD_WHEN_DOING_NOTHING = 0;
        DesertTile.COST_ADD = 0;
        DesertTile.COST_FACTOR = 2;
    }

    /**
     * Start the war game and give the course of the game.
     * @return Player the winner of the game.
     */
    @Override
    public Player play() throws GameException {
        initialize();
        if (this.players.isEmpty()) {
            throw new RuntimeException("Tried to play a game with no players");
        }

        Iterator<Player> it = this.players.listIterator();

        while (!this.isGameOver()) {
            Player p;
            if (it.hasNext()) {
                p = it.next();
            }
            else {
                it = this.players.listIterator();
                p = it.next();
                this.turns_counter++;
            }
            Action action = p.chooseAction(this.board);
            action.execute(this.board, p);
            p.collectResources();
            p.remunerateAll();
        }

        return findWinner();
    }

    protected boolean isGameOver() {
        return (this.board.isFull() || this.turns_counter == MAX_TURNS);
    }
}
