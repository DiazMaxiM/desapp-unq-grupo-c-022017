package exception;

import org.omg.CORBA.UserException;

public class InvalidLocalityAddressException extends UserException {

	private static final long serialVersionUID = 6051431835697123654L;

	public InvalidLocalityAddressException(String message) {
		super(message);
	}

}
