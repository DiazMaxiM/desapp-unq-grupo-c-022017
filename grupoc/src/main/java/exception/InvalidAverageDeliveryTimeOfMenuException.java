package exception;

public class InvalidAverageDeliveryTimeOfMenuException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	public InvalidAverageDeliveryTimeOfMenuException (String message) {
		super(message);
	}
}
