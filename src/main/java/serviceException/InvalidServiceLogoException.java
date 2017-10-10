package serviceException;

public class InvalidServiceLogoException extends Exception {
	private static final long serialVersionUID = 1L;
		
	public InvalidServiceLogoException (String message) {
		super(message);
	}
}
