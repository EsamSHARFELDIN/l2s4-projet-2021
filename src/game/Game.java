package game;
import game.Board;
import game.Player;

/**
  * An abstract class which allows to model the game.
  */

public abstract class Game {
    protected Board board;
    protected List<Player> players;
    
    /**
     * Creates a game with a given board and given players.
     * @param board a given board.
     * @param players given players.
     */
    public Game(int board, int players) {
        
    }

    /**
     * adds a player.
     * @param p The player to add.
     */
    public void addPlayer(Player p){

    }

    /**
     * removes a player
     * @param p The player to remove.
     */
    public void removePlayer(Player p){

    }

    /**
     * Start the game and give the course of the game.
     * @return Player the winner of the game.
     */
    public abstract Player play(){
        
    }
    
    /**
     * Makes sure the game is over.
     * @return True if the game is over, False otherwise.
     */
    private Boolean isGameOver(){

    }
}