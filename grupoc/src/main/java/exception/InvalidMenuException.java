package exception;

public class InvalidMenuException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidMenuException(String msg){
		super(msg);
	}

}