 


import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationStackTest_GFA {
	public NotationStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public NotationStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	Double A = 1.1, B = 2.0, C = 4.9, D = 6.4, E = 6.4, F = 7.7;
	
	@Before
	public void setUp() throws Exception {
		stringS = new NotationStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		
		doubleS = new NotationStack<Double>(6);
		doubleS.push(A);
		doubleS.push(B);
		doubleS.push(C);
		
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	// GARY | @Test
	public void testPopStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		
		try {
			
			assertEquals(A, doubleS.pop());
			assertEquals(B, doubleS.pop());
			assertEquals(C, doubleS.pop());
		
		} catch(StackUnderflowException e) {
			
			assertTrue("This should have caused an StackUnderflowException", true);
			
		}
	}
	
	@Test
	public void testTop() throws StackUnderflowException, StackOverflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	// GARY | @Test
	public void testPushStudent() {
		//Use the doubleS for student tests
		//fail("Not yet implemented");
		try {
			
			assertEquals(true, doubleS.push(6.4));
			assertEquals(true, doubleS.push(6.4));
			assertEquals(true, doubleS.push(7.7));
			assertEquals(6, doubleS.size());
			
		} catch (StackOverflowException e) {
			
			assertTrue("This should have caused an StackOverflowException", true);
			
		} catch(Exception e) {
			
			assertTrue("This should have caused an StackOverflowException", false);
			
		}
		
		
		
	}
	
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	// GARY | @Test
	public void testToStringStudent() throws StackOverflowException {
		//Use the doubleS for student tests
		//fail("Not yet implemented");
		
		assertEquals("abc", doubleS.toString());
		doubleS.push(6.4);
		assertEquals("abcd", doubleS.toString());
		doubleS.push(6.4);
		assertEquals("abcde", doubleS.toString());
		
	}
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new NotationStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
