package game;

/**
 * An exception class to indicate that an invalid tile was accessed
 */
public class UnknownTileException extends Exception {
    public UnknownTileException() {
        super();
    }

    public UnknownTileException(String message) {
        super(message);
    }
}
