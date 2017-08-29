package exception;

public class InvalidDeliveryPriceException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	public InvalidDeliveryPriceException (String message) {
		super(message);
	}
}
