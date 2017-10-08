package exception;

public class NoMenusFoundException extends SystemException {

	private static final long serialVersionUID = 1L;

	public NoMenusFoundException(String message) {
		super(message);
	}
}
