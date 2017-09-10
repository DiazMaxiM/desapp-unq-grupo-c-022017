package exception;

public class InvalidTelephoneNumberException extends Exception{
private static final long serialVersionUID = 1L;
	
	public InvalidTelephoneNumberException(String message) {
		super(message);
	}
}