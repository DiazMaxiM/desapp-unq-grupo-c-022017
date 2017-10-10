package menuExceptions;

public class InvalidMinimumPriceOfMenusToBuyException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidMinimumPriceOfMenusToBuyException (String message) {
		super(message);
	}
}
