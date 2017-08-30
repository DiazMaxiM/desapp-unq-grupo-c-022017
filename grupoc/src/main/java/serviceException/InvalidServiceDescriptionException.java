package serviceException;

public class InvalidServiceDescriptionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidServiceDescriptionException (String message) {
		super(message);
	}
}
