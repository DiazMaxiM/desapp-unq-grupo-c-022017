package serviceException;

public class InvalidServiceNameException extends Exception {
    private static final long serialVersionUID = 1L;
	
	public InvalidServiceNameException (String message) {
		super(message);
	}
}
