package exception;

public class InvalidStreetAddressException extends SystemException {

	private static final long serialVersionUID = 1L;

	public InvalidStreetAddressException(String message) {
		super(message);
	}
}
