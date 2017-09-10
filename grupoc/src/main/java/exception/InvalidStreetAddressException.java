package exception;

public class InvalidStreetAddressException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidStreetAddressException(String message) {
		super(message);
	}
}
