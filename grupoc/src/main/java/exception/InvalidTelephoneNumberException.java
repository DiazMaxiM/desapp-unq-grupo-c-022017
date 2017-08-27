package exception;

public class InvalidTelephoneNumberException extends Throwable {
private static final long serialVersionUID = 1L;
	
	public InvalidTelephoneNumberException(String message) {
		super(message);
	}
}