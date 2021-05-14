package game.exception;

/**
 * An exception class to indicate that an unspecified behaviour was invoked
 */
public class IllegalGameActionException extends GameException {
    public IllegalGameActionException() {
        super();
    }

    public IllegalGameActionException(String message) {
        super(message);
    }
}
