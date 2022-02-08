
public class NoSpecialCharacterException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339419665422476265L;

	public NoSpecialCharacterException() {
		
		
	}
	
	public NoSpecialCharacterException(String invalid) {
		
		super("The password must contain at least one special character ");
		
	}
}
