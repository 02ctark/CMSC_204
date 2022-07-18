
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;




/**
 * Double Linked List, my implementation!
 * @author Tark
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{

	
	//data fields
	protected Node<T> firstNode;
	protected Node<T> lastNode;
	protected int numberOfEntries;
	
	/**
	 * constructor
	 */
	BasicDoubleLinkedList(){
		
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
		
	}
	
	/**
	 * Returns the number of nodes in the list.
	 * Notice: Do not traverse the list to compute the size. 
	 * This method just returns the value of the instance variable you use to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize() {
		
		return numberOfEntries;
		
	}
	
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * DO NOT use iterators to implement this method.
	 * @param data - the data to be added to the list
	 */
	public void addToEnd(T data) {
		
		//create a node/inserting data
		Node<T> node = new Node<>(data);
		
		if(lastNode == null) {
			
			//first entry
			firstNode = node;
			lastNode = node;
			
		} else {
			

			node.setPreviousNode(lastNode);
			node.setNextNode(firstNode);
			//first i like to imagine a new node pops up. Now link the nodes to its corresponding firstNode and tail.
			//The original node is set the new node (firstNode and tail). 
			//lastNode set next node to new end node
			lastNode.setNextNode(node);	//Orginal previous set to next previous, with .setNextNode()
			lastNode = node;
			//Original next set to next next, with setPreviousNode()
			firstNode.setPreviousNode(lastNode);
			

			
		}
		
		numberOfEntries++;
		
	}
	
	/**
	 * Adds element to the front of the list and updated the size of the list
	 * Do not use iterators to implement this method.
	 * @param data - the data to be added to the list
	 */
	public void addToFront(T data) {
		
		//create a node/inserting data
		Node<T> node = new Node<>(data);
		
		if(firstNode == null) {
			
			firstNode = node;
			lastNode = node;
			
		} else {
		
			node.setNextNode(firstNode);
			node.setPreviousNode(lastNode);
			firstNode.setPreviousNode(node);
			firstNode = node;
			lastNode.setNextNode(firstNode);
			


			
		}
		
		numberOfEntries++;
		
	}
	
	/**
	 * Returns but does not remove the first element from the list.
	 * If there are no elements the method returns null.
	 * Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst() {
		
		return firstNode.getData();
		
	}
	
	/**
	 * Returns but does not remove the last element from the list.
	 * If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null

	 */
	public T getLast() {
		
		return lastNode.getData();
		
	}
	
	/**
	 * This method returns an object of the DoubleLinkedListIterator. 
	 * (the inner class that implements java's ListIterator interface)
	 * @return a ListIterator object
	 */
	public ListIterator<T> iterator(){
		
		return new DoubleLinkedListIterator<T>(firstNode);
		
	}
	
	/**
	 * Removes the first instance of the targetData from the list. 
	 * Notice that you must remove the elements by performing a single traversal over the list. 
	 * You may not use any of the other retrieval methods associated with the class in order to complete the removal process. 
	 * You must use the provided comparator (do not use equals) to find those elements that match the target. 
	 * Do not implement this method using iterators.
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the targetData or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		
		//creating node with firstNode
		Node<T> node = firstNode;
		
		//if size is zero then throw exception

		
		//through the whole linked list
		while(node != null) {
			
			//if target is the same value as current node then set that value accordingly
			if(comparator.compare(targetData, node.getData()) == 0) {
				
				numberOfEntries--;
				
				//if node = lastNode, means firstNode = lastNode. increment to previous node
				if(node == lastNode) {
					
					lastNode = lastNode.getPreviousNode();
					
				//if node = firstNode, means firstNode = firstNode. increment to next node
				} else if(node == firstNode) {
					
					firstNode = firstNode.getNextNode();
					
				} else {
					
					//getnext is next
					node.previous.next = node.next;
					
				}
				
				return null;
				
			}
			
			//could not find targetData move on the the next node
			node = node.getNextNode();
			
		}
		
		return null;
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. 
	 * Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		
		if(numberOfEntries == 0) {
			
			return null;
			
		} else {
			
			//get first node data
			T data = firstNode.getData();
			//firstnode is moved to the previous node
			firstNode = firstNode.getNextNode();
			//arrange the previous node as current node
			firstNode.setPreviousNode(lastNode);
			lastNode.setNextNode(firstNode);
			
			numberOfEntries--;
			return data;
		}
		
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null. 
	 * Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		
		if(numberOfEntries == 0) {
			
			return null;
			
		} else { 
			
			//get data of last node/element
			T data = lastNode.getData();
			//lastNode is moved to the next node
			lastNode = lastNode.getPreviousNode();
			//arrange the next node as current node
			lastNode.setNextNode(firstNode);
			firstNode.setPreviousNode(lastNode);
			
			numberOfEntries--;
			return data;
			
		}
	}
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList(){
		
		ArrayList<T> al = new ArrayList<T>();
		Node<T> node = firstNode;
	
		DoubleLinkedListIterator<T> iterator = (BasicDoubleLinkedList<T>.DoubleLinkedListIterator<T>) iterator();
		
		while(iterator.hasNext()) {
			
			al.add(iterator.next());
		}

		return al;
		
	}
		
		
		

	
	

	
	/**
	 * private Node class, dictates reference to node, next, or previous 
	 * @author Tark
	 *
	 * @param <T>
	 */

	protected class Node<T>{
		
		//data fields
		//A generic inner class Node - This class has the following attributes:
		//data of type T
		//prev of type Node
		//next of type Node
		
		protected T data;
		protected Node<T> next;
		protected Node<T> previous;
		
		/**
		 * Initialize three nodes data, next node, and previous node.
		 * @param dataNode - data of node
		 */
		Node(T dataNode){
			
			this.data = dataNode;
			this.next = null;
			this.previous = null;
			
		}

		/**
		 * Associate input data into containing node
		 * @param dataNode - data of node
		 */
		public void setData(T dataNode) {
			
			data = dataNode;
			
		}
		
		/**
		 * Return data in the node
		 * @return data - data of node
		 */
		public T getData() {
			
			return data;
			
		}
		
		/**
		 * Associate the next node
		 * @param nextNode - input data
		 */
		public void setNextNode(Node<T> nextNode) {
			
			next = nextNode;
			
		}
		
		/**
		 * Return next node from current node
		 * @return next - data of the next node
		 */
		public Node<T> getNextNode() {
			
			return next;
		}
		
		/**
		 * Associate the previous node
		 * @param previousNode - input data
		 */
		public void setPreviousNode(Node<T> previousNode) {
			
			previous = previousNode;
			
		}
		
		/**
		 * Return previous node from current node
		 * @return previous - data of previous node
		 */
		public Node<T> getPreviousNode() {
			
			return previous;
			
		}
		
		
		
		
	}




	
	
	/**
	 * A generic inner class named DoubleLinkedListIterator that implements java’s ListIterator 
	 * interface (for the iterator method).
	 * @author Tark
	 *
	 * @param <T>
	 */

	private class DoubleLinkedListIterator<T> implements ListIterator<T>{
		
		
		//data fields
		protected Node<T> finger; //firstNode
		private int count;
		
		/**Constructor to initialize the current pointer to the 
		 * head of the BasicDoubleLinkedList.
		 * 
		 */
		DoubleLinkedListIterator(Node<T> node){
			
			finger = node;
			count = 0;
			
		}
		
	    /**
	     * Returns {@code true} if this list iterator has more elements when
	     * traversing the list in the forward direction. (In other words,
	     * returns {@code true} if {@link #next} would return an element rather
	     * than throwing an exception.)
	     *
	     * @return {@code true} if the list iterator has more elements when
	     *         traversing the list in the forward direction
	     */
		public boolean hasNext() {
			
			// as long as the count is less than the number of entries then there will always be a hasNext
			return  numberOfEntries > count;
 			
		}
		
	    /**
	     * Returns the next element in the list and advances the cursor position.
	     * This method may be called repeatedly to iterate through the list,
	     * or intermixed with calls to {@link #previous} to go back and forth.
	     * (Note that alternating calls to {@code next} and {@code previous}
	     * will return the same element repeatedly.)
	     *
	     * @return the next element in the list
	     * @throws NoSuchElementException if the iteration has no next element
	     */
		public T next() throws NoSuchElementException{
			
			//iterate through array untill there is no more data
			if(hasNext()) {
				
				// store data that node was on
				T data = finger.getData();
				//increment to the next node
				finger = finger.getNextNode();
				count++;
				
				return data;
				
			}
			
			throw new NoSuchElementException("Illegal call to next()");
			
		}
		
		/**
	     * Returns {@code true} if this list iterator has more elements when
	     * traversing the list in the reverse direction.  (In other words,
	     * returns {@code true} if {@link #previous} would return an element
	     * rather than throwing an exception.)
	     *
	     * @return {@code true} if the list iterator has more elements when
	     *         traversing the list in the reverse direction
	     */
		public boolean hasPrevious() {
			
			//as long as count stays positive then there will always be a hasPrevious()
			return count > 0;
			
		}
		
		/**
	     * Returns the previous element in the list and moves the cursor
	     * position backwards.  This method may be called repeatedly to
	     * iterate through the list backwards, or intermixed with calls to
	     * {@link #next} to go back and forth.  (Note that alternating calls
	     * to {@code next} and {@code previous} will return the same
	     * element repeatedly.)
	     *
	     * @return the previous element in the list
	     * @throws NoSuchElementException if the iteration has no previous
	     *         element
	     */
		public T previous() throws NoSuchElementException{
			
			if(hasPrevious()) {
				//decrement first for the correct previoushas() node
				finger = finger.getPreviousNode();
				//store the currrent previous
				T data = finger.getData();
				//make sure count is decremented
				count--;

				return data;
				
			}
			
			throw new NoSuchElementException("Illegal call to previous()");
		}
		
	    /**
	     * Removes from the list the last element that was returned by {@link
	     * #next} or {@link #previous} (optional operation).  This call can
	     * only be made once per call to {@code next} or {@code previous}.
	     * It can be made only if {@link #add} has not been
	     * called after the last call to {@code next} or {@code previous}.
	     *
	     * @throws UnsupportedOperationException if the {@code remove}
	     *         operation is not supported by this list iterator
	     * @throws IllegalStateException if neither {@code next} nor
	     *         {@code previous} have been called, or {@code remove} or
	     *         {@code add} have been called after the last call to
	     *         {@code next} or {@code previous}
	     */
		public void remove() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException("Not functional");
		}
		
	    /**
	     * Inserts the specified element into the list (optional operation).
	     * The element is inserted immediately before the element that
	     * would be returned by {@link #next}, if any, and after the element
	     * that would be returned by {@link #previous}, if any.  (If the
	     * list contains no elements, the new element becomes the sole element
	     * on the list.)  The new element is inserted before the implicit
	     * cursor: a subsequent call to {@code next} would be unaffected, and a
	     * subsequent call to {@code previous} would return the new element.
	     * (This call increases by one the value that would be returned by a
	     * call to {@code nextIndex} or {@code previousIndex}.)
	     *
	     * @param e the element to insert
	     * @throws UnsupportedOperationException if the {@code add} method is
	     *         not supported by this list iterator
	     * @throws ClassCastException if the class of the specified element
	     *         prevents it from being added to this list
	     * @throws IllegalArgumentException if some aspect of this element
	     *         prevents it from being added to this list
	     */
		public void add(T arg0) throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException("Not functional");
			
		}
		
		/**
	     * Returns the index of the element that would be returned by a
	     * subsequent call to {@link #next}. (Returns list size if the list
	     * iterator is at the end of the list.)
	     *
	     * @return the index of the element that would be returned by a
	     *         subsequent call to {@code next}, or list size if the list
	     *         iterator is at the end of the list
	     */
		public int nextIndex() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException("Not functional");
			
		}
		
		 /**
	     * Returns the index of the element that would be returned by a
	     * subsequent call to {@link #previous}. (Returns -1 if the list
	     * iterator is at the beginning of the list.)
	     *
	     * @return the index of the element that would be returned by a
	     *         subsequent call to {@code previous}, or -1 if the list
	     *         iterator is at the beginning of the list
	     */
		public int previousIndex() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException("Not functional");
			
		}
		
	    /**
	     * Replaces the last element returned by {@link #next} or
	     * {@link #previous} with the specified element (optional operation).
	     * This call can be made only if neither {@link #remove} nor {@link
	     * #add} have been called after the last call to {@code next} or
	     * {@code previous}.
	     *
	     * @param e the element with which to replace the last element returned by
	     *          {@code next} or {@code previous}
	     * @throws UnsupportedOperationException if the {@code set} operation
	     *         is not supported by this list iterator
	     * @throws ClassCastException if the class of the specified element
	     *         prevents it from being added to this list
	     * @throws IllegalArgumentException if some aspect of the specified
	     *         element prevents it from being added to this list
	     * @throws IllegalStateException if neither {@code next} nor
	     *         {@code previous} have been called, or {@code remove} or
	     *         {@code add} have been called after the last call to
	     *         {@code next} or {@code previous}
	     */
		public void set(T arg0) throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException("Not functional");
			
		}
		
		
	}
	
	
	
	//end of BasicDoubleLinkedList
	
}
