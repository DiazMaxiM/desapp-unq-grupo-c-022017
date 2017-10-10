package userExceptions;

public class InvalidEmailAddressException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidEmailAddressException(String msg) {
		super(msg);
	}
     
} 
