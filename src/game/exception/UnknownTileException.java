package game.exception;

/**
 * An exception class to indicate that an invalid tile was accessed.
 * For example, in a board when trying to access a tile which does not 
 * exist.
 */
public class UnknownTileException extends GameException {
    public UnknownTileException() {
        super();
    }

    public UnknownTileException(String message) {
        super(message);
    }
}
