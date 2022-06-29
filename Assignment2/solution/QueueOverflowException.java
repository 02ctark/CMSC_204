

/**
 * Occurs when an enqueue method is called on a full queue
 * 
 * @author Christopher Tark
 *
 */
public class QueueOverflowException extends Exception {

	QueueOverflowException(){
		
		super("The queue excceds maximum number of entries");
		
	}
	
	QueueOverflowException(String message){
		
		super(message);
		
	}
}
