

/**
 * Occurs when a Notation format is incorrect
 * 
 * @author Christopher Tark
 *
 */
public class InvalidNotationFormatException extends Exception {

	InvalidNotationFormatException(){
		
		super("The notation format is incorrect.");
		
	}
	
	InvalidNotationFormatException(String message){
		
		super(message);
		
	}
}


