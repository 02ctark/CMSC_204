
/**
 * Thrown if password contains 6 to 9 characters which iare othwise valid
 * @author Christopher Tark
 *
 */
public class WeakPasswordException extends Exception{

	/**
	 * constructor displaying default error
	 */
	WeakPasswordException(){
		
		super("Password is OK but weak - it contains few than 10 characters");
		
	}
	
	/**
	 * parameterized constructor display string
	 * @param message
	 */
	WeakPasswordException(String message){
		
		super(message);
	}
	
	
}
