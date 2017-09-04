package orderExceptions;

public class InvalidNumberOfMenusToOrderException extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidNumberOfMenusToOrderException(String msg){
		super(msg);
	}

}
