package serviceException;

public class InvalidServiceWorkingHoursException extends Exception {
     private static final long serialVersionUID = 1L;
	
	public InvalidServiceWorkingHoursException(String message) {
		super(message);
	}
}
