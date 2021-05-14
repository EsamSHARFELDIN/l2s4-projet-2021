package game;

import game.game.Game;

/**
 * A mock game class for the purpose of testing the behaviours of the abstract
 * class Game
 */
public class GameMock extends Game {
    public GameMock(int width, int height) {
        super(width, height);
    }

    public Player play() {
        return null;
    }

    protected boolean isGameOver() {
        return true;
    }
}
