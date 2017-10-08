package exception;

public class NumberOfMenusExceededException extends SystemException {

	private static final long serialVersionUID = 1L;

	public NumberOfMenusExceededException(String message) {
		super(message);
	}
}
