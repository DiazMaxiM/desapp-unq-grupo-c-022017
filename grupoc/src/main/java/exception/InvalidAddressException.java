package exception;

import org.omg.CORBA.UserException;

public class InvalidAddressException extends UserException {
	private static final long serialVersionUID = 1L;
	
	public InvalidAddressException(String message) {
		super(message);
	}

}
