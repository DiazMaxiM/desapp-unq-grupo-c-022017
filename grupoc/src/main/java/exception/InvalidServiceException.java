package exception;

public class InvalidServiceException extends SystemException {

	private static final long serialVersionUID = 1L;

	public InvalidServiceException(String message) {
		super(message);
	}

}
