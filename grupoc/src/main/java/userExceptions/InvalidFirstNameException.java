package userExceptions;

public class InvalidFirstNameException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidFirstNameException(String msg){
		super(msg);
	}

}
