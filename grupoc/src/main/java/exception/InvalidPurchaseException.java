package exception;

public class InvalidPurchaseException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidPurchaseException(String message) {
		super(message);
	}

}
