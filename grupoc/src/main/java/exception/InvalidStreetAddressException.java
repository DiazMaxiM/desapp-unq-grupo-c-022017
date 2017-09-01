package exception;

import org.omg.CORBA.UserException;

public class InvalidStreetAddressException extends UserException {

	private static final long serialVersionUID = -2023406153409168759L;

	public InvalidStreetAddressException(String message) {
		super(message);
	}
}
