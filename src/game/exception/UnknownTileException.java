package game.exception;

/**
 * An exception class to indicate that an invalid tile was accessed
 */
public class UnknownTileException extends GameException {
    public UnknownTileException() {
        super();
    }

    public UnknownTileException(String message) {
        super(message);
    }
}
