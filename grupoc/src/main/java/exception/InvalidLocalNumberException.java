package exception;

import org.omg.CORBA.UserException;

public class InvalidLocalNumberException extends UserException {

	private static final long serialVersionUID = -2603277436046629050L;

	public InvalidLocalNumberException(String message) {
		super(message);
	}
    
	
}
