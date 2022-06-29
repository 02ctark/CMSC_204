import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * MY IMPLEMENTATION OF A STACK
 * @author Tark
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T> {

	//fields
	private static final int MAX_CAPACITY = 10000;
	private static final int DEFAULT_CAPACITY = 25;
	private T[] stack;	// array called stack
	private int topIndex; //top entry
	private boolean integrityOk;
	
	
	//constructor
	NotationStack() {
		
		this(DEFAULT_CAPACITY);
		
	}
	
	NotationStack(int capacity){
		
		integrityOk = false;
		
		checkCapacity(capacity);
		
		//create array and set equal to stack
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[capacity];
		stack = tempStack;
		
		
		topIndex = -1;
		integrityOk = true;
		

		
	}
	
	/**
	 * Security protocol, if integrityOk is false then there needs to be an error
	 */
	@SuppressWarnings("unused")
	private void checkIntegrity() {
		
		if(!integrityOk) {
			
			throw new SecurityException("The new Object is corrupted.");
		}
	}
	
	/**
	 * increase the length of array if full
	 */
	@SuppressWarnings("unused")
	private void ensureCapacity() {
		
		//if array is full, double its original size
		if(isFull()) {
			
			int newSize = 2 * stack.length;
			checkCapacity(newSize);
			stack = Arrays.copyOf(stack, newSize);
			
		}
	}
	
	@SuppressWarnings("unused")
	private void checkCapacity(int capacity) {
		
		if(capacity > MAX_CAPACITY) {
			
			throw new IllegalStateException("Capacity exceeds maximum limit.");
		}
	}


	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex == -1;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return topIndex == stack.length - 1;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		
		if(isEmpty()) {
			
			throw new StackUnderflowException();
			
		}
		
		T top = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		
		return top;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		
		checkIntegrity();
		
		if(isEmpty()) {
			
			throw new StackUnderflowException();
			
		}
		
		return stack[topIndex];
		
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return topIndex + 1;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		// TODO Auto-generated method stub
		
		checkIntegrity();
		
		if(isFull()) {
			
			throw new StackOverflowException();

		}else {
			
			topIndex++;
			stack[topIndex] = e;
		
			return true;
		}
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		
		String str = "";
		String finalstr = "";
		
		for(T string : stack) {
			
			if(string == null)
			str += "";
			else
				str += string;
				
			
		}
		
		//add for postfix to infix
		if(str.startsWith("(") && str.endsWith(")")) {
			
			finalstr += str.substring(1, str.length()-1);
			
			return finalstr;
		}
		
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
	
		String str = "";
		String finalstr = "";
		
		for(int i = 0; i < stack.length; i++) {
			
			if(stack[i] == null)
				
			str += "";
			
			else {
				
				//print out string
				str += stack[i] + delimiter;
				
			}
			
		}
		
		//remove delimiter from the end
		if(str.endsWith(delimiter))
			finalstr += str.substring(0, str.length() - 1);
		
		return finalstr;
		
	}

	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		
		ArrayList<T> al = new ArrayList<>(list);
		
		//iterate through the list
		al.forEach(element -> {
			
			try {
				
				push(element);
				
			} catch (StackOverflowException e) {
				
				e.getMessage();
				
			}
			
		});
		
		  
		
	}
	

}
