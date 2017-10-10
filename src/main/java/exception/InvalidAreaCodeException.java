package exception;

public class InvalidAreaCodeException extends SystemException {

	private static final long serialVersionUID = 1L;

	public InvalidAreaCodeException(String message) {
		super(message);
	}

}
