package exception;

public class InvalidPurchaseException extends SystemException {
	private static final long serialVersionUID = 1L;

	public InvalidPurchaseException(String message) {
		super(message);
	}

}
