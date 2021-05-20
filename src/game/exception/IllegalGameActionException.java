package game.exception;

/**
 * An exception class to indicate that an unspecified behavior was invoked.
 * Something like trying to perform an action that does not follow the game's rules.
 */
public class IllegalGameActionException extends GameException {
	
	/**
     * Construct an IllegalGameActionException.
     */
    public IllegalGameActionException() {
        super();
    }

    /**
     * Construct an IllegalGameActionException with the given message.
     * 
     * @param message the detail message.
     */
    public IllegalGameActionException(String message) {
        super(message);
    }
}
