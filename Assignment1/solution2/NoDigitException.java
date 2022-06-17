
/**
 * Thrown if password does not contain a numeric character
 * @author Christopher Tark
 *
 */
public class NoDigitException extends Exception{

	/**
	 * constructor displaying default error
	 */
	NoDigitException(){
		
		super("The password must contain at least one digit");
		
	}
	
	/**
	 * parameterized constructor
	 * @param message display string
	 */
	NoDigitException(String message){
		
		super(message);
		
	}
}
