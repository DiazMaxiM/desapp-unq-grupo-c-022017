package exception;

public class InvalidAddressException extends SystemException {
	private static final long serialVersionUID = 1L;

	public InvalidAddressException(String message) {
		super(message);
	}

}
