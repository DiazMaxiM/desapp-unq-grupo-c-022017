package userExceptions;

public class InvalidCuitException extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidCuitException(String msg){
		super(msg);
	}

}
