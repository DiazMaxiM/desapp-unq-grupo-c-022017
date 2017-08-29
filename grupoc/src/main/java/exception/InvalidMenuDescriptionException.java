package exception;

public class InvalidMenuDescriptionException extends Exception {
	 private static final long serialVersionUID = 1L;
		
	public InvalidMenuDescriptionException(String message) {
			super(message);
	}
}
