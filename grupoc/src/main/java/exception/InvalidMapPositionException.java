package exception;

public class InvalidMapPositionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidMapPositionException(String message) {
		super(message);
	}
}
