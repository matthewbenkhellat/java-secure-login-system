
public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {
		super("The password that you have entered is not valid, please retry with another password");
	}
	
	public InvalidPasswordException(String message) {
		super(message);
	}
}
