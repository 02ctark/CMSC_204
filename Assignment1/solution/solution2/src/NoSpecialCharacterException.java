
/**
 * Thrown if password does not contain a special character.
 * @author chris
 *
 */
public class NoSpecialCharacterException extends Exception {

	NoSpecialCharacterException(){
		
		super("The password must contain at least one special character");
		
	}
	
	NoSpecialCharacterException(String message){
		
		super(message);
		
	}
}
