package exception;

public class InvalidCountryCodeException extends SystemException {

	private static final long serialVersionUID = 1L;

	public InvalidCountryCodeException(String message) {
		super(message);
	}

}
