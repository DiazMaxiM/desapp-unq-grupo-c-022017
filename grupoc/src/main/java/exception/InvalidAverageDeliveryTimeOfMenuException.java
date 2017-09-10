package exception;

public class InvalidAverageDeliveryTimeOfMenuException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidAverageDeliveryTimeOfMenuException (String message) {
		super(message);
	}
}
