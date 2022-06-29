import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Circular array-based implementation
 * 
 * @author Tark
 *
 * @param <T>
 */
public class NotationQueue<T> implements QueueInterface<T>{

	//fields
	private T[] queue;
	private int numberOfEntries;
	private int first;
	private int last;
	private final static int DEFAULT_CAP = 50;

	
	//constructor
	NotationQueue(){
		
		this(DEFAULT_CAP);
		
	}
	
	NotationQueue(int capacity){
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[capacity + 1];
		queue = tempQueue;
		
		first = 0;
		//after incrementing the first item enqueued is place in element zero in the array
		last = capacity;
		numberOfEntries = 0;
		
	}
	
	
	/**
	 * if the queue array is full, double the original size.
	 */
	private void ensureCapacity() {
		
		if(isFull()) {
			
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			
			@SuppressWarnings("unchecked")
			T[] tempQueue1 = (T[]) new Object[2* oldSize];
			queue = tempQueue1;
			
			for(int i = 0; i < oldSize - 1 ; i++) {
				
				queue[i] = oldQueue[first];
				//increment
				first = (first + 1) % oldQueue.length;
				
			}
			
			first = 0;
			last = oldSize - 2;
		}
	}
	
	
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		//test for an empty queue
		return first == (last + 1) % queue.length;
	
	}

	
	/**
	 * Determines of the Queue is empty
	 * @return true if Queue is full
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		//test for a full queue
		//when first equals 
		return first == (last + 2) % queue.length;
		
	}
	


	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		
		if(isEmpty()) {
			
			throw new QueueUnderflowException();
			
		}
		
		//set front to current first element to return
		T front = null;
		front = queue[first];
		//set first element in queue to null
		queue[first] = null;
		//increment to next element
		first = (first + 1) % queue.length;
		numberOfEntries--;
		
		return front;
		
	}

	
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return numberOfEntries;
	}


	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		
		if(isFull()) {
			
			throw new QueueOverflowException();
			
		}
		
		ensureCapacity();
		
		//lets say the there are 49 elements, that means queue.length = 50. also last is equal 50
		//plugging the numbers in 51 % 50
		//below, increments the last position
		last = (last + 1) % queue.length;
		//set incremented position to input
		queue[last] = e;
		numberOfEntries++;
		
		return true;
	}
	

	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
	
		String str = "";
		
		for(T string : queue) {
			
			if(string == null)
			str += "";
			else
				str += string;
				
			
		}
		
		return str;
		

	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String str = "";
		String finalstr = "";
		
		for(int i = 0; i < queue.length; i++) {
			
			if(queue[i] == null)
				
			str += "";
			
			else {
				
				//print out string
				str += queue[i] + delimiter;
				
			}
			
		}
		
		//remove delimiter from the end
		if(str.endsWith(delimiter))
			finalstr += str.substring(0, str.length() - 1);
		
		return finalstr;
		


	}


	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub

		ArrayList<T> al = new ArrayList<>(list);
		
		//iterate through the list
		al.forEach(element -> {
			
			try {
				
				enqueue(element);
				
			} catch (QueueOverflowException e) {
				
				e.getMessage();
				
			} 
			
		});
		
		  
	}


		
		
	


}