package exception;

public class InvalidMapPositionException extends Throwable {
	private static final long serialVersionUID = 1L;
	
	public InvalidMapPositionException(String message) {
		super(message);
	}
}
