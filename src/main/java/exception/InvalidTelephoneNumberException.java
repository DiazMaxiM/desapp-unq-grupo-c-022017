package exception;

public class InvalidTelephoneNumberException extends SystemException {
	private static final long serialVersionUID = 1L;

	public InvalidTelephoneNumberException(String message) {
		super(message);
	}
}