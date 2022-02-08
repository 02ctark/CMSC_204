
public class NoDigitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1641953799507813742L;


	public NoDigitException() {
		
		super("The password must contain at least one digit");
	}
}
