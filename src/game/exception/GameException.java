package game.exception;

/**
 * A class which is a subclass of all new exceptions class related
 * to the game.
 *
 */
public class GameException extends Exception {

    /**
     * Create a new game exception.
     */
    public GameException() {
    }

    /**
     * Create a new game exception with the given message.
     *
     * @param message message describing briefly the exception.
     */
    public GameException(String message) {
        super(message);
    }
}
