package game.exception;

/**
 * An exception class to indicate that an invalid tile was accessed.
 * For example, in a board when trying to access a tile which does not
 * exist.
 */
public class UnknownTileException extends GameException {
    /**
     * Construct an UnknownTileException.
     */
    public UnknownTileException() {
        super();
    }

    /**
     * Construct an UnknownTileException with the give message.
     * @param message the detail message.
     */
    public UnknownTileException(String message) {
        super(message);
    }
}
