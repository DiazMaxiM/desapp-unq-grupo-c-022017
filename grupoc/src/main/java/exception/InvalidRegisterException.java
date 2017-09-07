package exception;

public class InvalidRegisterException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public InvalidRegisterException(String msg){
		super(msg);
	}

}
