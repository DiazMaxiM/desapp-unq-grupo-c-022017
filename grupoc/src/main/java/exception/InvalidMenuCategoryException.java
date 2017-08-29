package exception;

public class InvalidMenuCategoryException extends Exception {
	 private static final long serialVersionUID = 1L;
		
	public InvalidMenuCategoryException(String message) {
			super(message);
	}
}
