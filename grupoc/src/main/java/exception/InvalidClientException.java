package exception;

public class InvalidClientException extends SystemException {
	private static final long serialVersionUID = 1L;

	public InvalidClientException(String msg) {
		super(msg);
	}

}
