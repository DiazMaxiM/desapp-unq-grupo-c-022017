package serviceException;

public class InvalidServiceEmailException extends Exception {
     private static final long serialVersionUID = 1L;
	
	public InvalidServiceEmailException(String message) {
		super(message);
	}
}
