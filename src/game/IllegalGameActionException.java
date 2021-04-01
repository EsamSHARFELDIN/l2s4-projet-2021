package game;

/**
 * An exception class to indicate that an unspecified behaviour was invoked
 */
public class IllegalGameActionException extends Exception {
    public IllegalGameActionException() {
        super();
    }

    public IllegalGameActionException(String message) {
        super(message);
    }
}
