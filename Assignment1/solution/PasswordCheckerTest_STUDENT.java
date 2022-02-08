

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> passwords;
	
	String password1, password2;
	
	private Scanner scan;

	@Before
	public void setUp() throws Exception {
		
		
		String[] p = {"Pinecone3432!", "inva1", "AppleSauce", "fdsglfdglkj123", "SDLJKFLKJ123", "HHHHH54"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
	}

	@After
	public void tearDown() throws Exception {
	
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("Fel12");
			assertTrue("Did not throw lengthException",true);
		
			} catch(LengthException e) {
				assertTrue("Threw lengthExcepetion", false);
			} catch(Exception e) {
				assertTrue("Invalid exception thrown", true);
	}

	
	}
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Pinecone3432!"));
			PasswordCheckerUtility.isValidPassword("fdsglfdglkj123");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("AppleSauce!2"));
			PasswordCheckerUtility.isValidPassword("SDLJKFLKJ123");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("inva1"));
			assertFalse(PasswordCheckerUtility.isWeakPassword("Apples365666!"));
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Apples365666!"));
			PasswordCheckerUtility.isValidPassword("HHHHH54");
			assertTrue("Did not throw InvalidSequenceException",false);
			
		}
		
		catch(InvalidSequenceException e)
		
		{
			assertTrue("Successfully threw an InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Pinecone3432!"));
			PasswordCheckerUtility.isValidPassword("dsfjlsLKJDFSLdsfsd");
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		//fail("Not implemented by student yet");
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Apples365666!")); //valid password
			PasswordCheckerUtility.isValidPassword("inva1"); //invalid password
			assertTrue("Did not throw any Exception",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some exception.",true);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//fail("Not implemented by student yet");
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "inva1");
		
	}
	
}