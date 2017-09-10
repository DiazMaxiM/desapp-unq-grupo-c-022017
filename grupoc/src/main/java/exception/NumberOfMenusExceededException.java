package exception;

public class NumberOfMenusExceededException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumberOfMenusExceededException(String message) {
		super(message);
	}
}
