package exception;

public class InvalidEndDateOfferMenuException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	public InvalidEndDateOfferMenuException(String message) {
		super(message);
	}
}