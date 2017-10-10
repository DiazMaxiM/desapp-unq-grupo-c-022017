package menuExceptions;

public class InvalidMenuNameException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidMenuNameException(String message) {
		super(message);
	}
}
