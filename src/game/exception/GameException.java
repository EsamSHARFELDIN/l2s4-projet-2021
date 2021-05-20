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
	
	/**
	 * Constructs a new exception with the specified cause
	 * and a detail message of (cause==null ? null: cause.toString())
	 * 
	 * 
	 */
	public GameException(Throwable cause) {
		super(cause);
	}
	
	
	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * Note that the detail message associated with cause is not automatically 
	 * incorporated in this exception's detail message.
	 * 
	 * @param message the detail message
	 * @param cause the cause
	 */
	public GameException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	/**
	 * Constructs a new exception with the specified detail message, cause, 
	 * suppression enabled or disabled, and writable stack trace enabled or disabled.
	 * 
	 * @param message the detail message
	 * @param cause the cause
	 * @param enableSuppression whether or not suppression is enabled or disabled
	 * @param writableStackTrace whether or not the stack trace should be writable
	 */
	public GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
