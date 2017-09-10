package exception;

public class InvalidServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidServiceException(String message) {
		super(message);
	}

}
