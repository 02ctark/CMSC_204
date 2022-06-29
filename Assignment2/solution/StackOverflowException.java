
/**
 * Occurs when a push method is called on a full stack
 * 
 * @author Christopher Tark
 * @version 1
 *
 */

public class StackOverflowException extends Exception{
	
	StackOverflowException(){
		
		super("The stack exceeds the maximum number of entries.");
		
	}

	
	StackOverflowException(String message){
		
		super(message);
		
	}
}
