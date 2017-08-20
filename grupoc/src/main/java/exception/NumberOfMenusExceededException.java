package exception;

import org.omg.CORBA.UserException;

@SuppressWarnings("all")
public class NumberOfMenusExceededException extends UserException {
	public NumberOfMenusExceededException(String message){
		super(message);
	}
}
