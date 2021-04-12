package game;

/**
 * A mock game class for the purpose of testing the behaviours of the abstract
 * class Game
 */
public class GameMock extends Game {
    public MockGame(int width, int height) {
        super(width, height);
    }

    public Player play() {
        return null;
    }
}
