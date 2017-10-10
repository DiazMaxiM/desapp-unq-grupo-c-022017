package menuExceptions;

public class InvalidMinimumNumberOfMenusToBuyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public InvalidMinimumNumberOfMenusToBuyException(String message) {
		super(message);
	}
}
