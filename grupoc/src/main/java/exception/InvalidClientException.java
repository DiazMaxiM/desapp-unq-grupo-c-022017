package exception;

public class InvalidClientException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidClientException(String msg){
		super(msg);
	}

}
