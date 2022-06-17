

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is your test file.  Complete the following test cases to test your project where they make sense.
 * Include additional test cases if you like.  
 *
 * STUDENT tests for the methods of PasswordChecker
 * @author Christopher Tark
 * @version 6/12/22
 *
 */
public class PasswordCheckerSTU_Test_ChrisTark {
	
	//declare testing variables
	ArrayList<String> passwordList;
	
	//String p1, p2;
	
	
	@Before
	public void setUp() throws Exception {
		
		String[] passwords = {"a1A#b1Bc1Cd1D",
				"334455BB#",
				"Im2cool4U#",
				"george2ZZZ",
				"4Sale#",
				"bertha22",
				"4wardMarch#",
				"ast",
				"a2cDe",
				"ApplesxxYYzz#",
				"aa11bb",
				"pilotProject",
				"myPassword","myPassword2","myPassword2#"};

		passwordList = new ArrayList<String>();
		
		//transfer indices array to array list
		passwordList.addAll(Arrays.asList(passwords));
		

		

	}

	@After
	public void tearDown() throws Exception {
		
		//passwordList = null;
		//passwordss = null;
		// = null;
		//p2 = null;
		
	}
	


	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertTrue(PasswordCheckerUtility.isValidLength("cSjkglfj435"));
			PasswordCheckerUtility.isValidLength("dsf4");
			assertTrue("lengthException not thrown" , false);
			
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			
			assertTrue("Successfully threw lengthException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", false);
		}
		
		
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("ddsf435"));
			PasswordCheckerUtility.hasUpperAlpha("34534");
			assertTrue("NoUpperAlphaException not thrown", false);
			
		} catch (NoUpperAlphaException e) {
			
			assertTrue("Successfully threw NoAlphaUpperException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("DSFSDEWR7987*"));
			assertTrue("NoLowerAlphaException not thrown", false);
		} catch (NoLowerAlphaException e) {
			
			assertTrue("Successfully threw NoLowerAlphaException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", false);
		}
		
	}
	/**
	 * Test if the password has between 6 and 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertTrue(PasswordCheckerUtility.isWeakPassword("As35dsd"));
			assertEquals( false, PasswordCheckerUtility.isWeakPassword("As35dsddsf"));
		} catch (WeakPasswordException e) { 
			
			assertTrue("Successfully threw WeakPasswordException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", false);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertEquals(true, PasswordCheckerUtility.hasSameCharInSequence("ccchloecaitlyn119"));
			PasswordCheckerUtility.hasSameCharInSequence("Monkey");
			assertTrue("InvalidSequenceException not thrown", false);
			
		} catch (InvalidSequenceException e) { 
			
			assertTrue("Successfully threw InvalidSequenceException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", false);
		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit(){
		//fail("Not implemented by student yet");
		
		try {
			
			assertTrue(PasswordCheckerUtility.hasDigit("Hamburgur*$$"));
			
			assertTrue("NoDigitException not thrown", false);
			
		} catch (NoDigitException e) { 
			
			assertTrue("Successfully threw InvalidSequenceException", true);
			
		} catch (Exception e) {
			
			assertTrue("Another exception was thrown", true);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful(){
		//fail("Not implemented by student yet");
	
		
			try {
				
				assertTrue(PasswordCheckerUtility.isValidPassword("AbrahamL34&3."));
				
			} catch ( Exception e ) {
				
				System.err.println(e.getMessage());
			}
		
	}
	
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//fail("Not implemented by student yet");
		 
		
		  ArrayList<String> list; 
		  list = PasswordCheckerUtility.getInvalidPasswords(passwordList);
		  
		  Scanner sc = new Scanner(list.get(00)); 
		  assertEquals("334455BB#", sc.next());
		  String test = sc.nextLine();
		  assertTrue(test.contains("lowercase"));
		  
		  sc = new Scanner(list.get(01)); 
		  assertEquals("george2ZZZ", sc.next());
		  test = sc.nextLine();
		  assertTrue(test.contains("special"));

		  sc = new Scanner(list.get(02)); 
		  assertEquals("bertha22", sc.next());
		  test = sc.nextLine();
		  assertTrue(test.contains("uppercase"));
		  
		  sc = new Scanner(list.get(03)); 
		  assertEquals("ast", sc.next());
		  test = sc.nextLine();
		  assertTrue(test.contains("long"));
		  
		  sc = new Scanner(list.get(05)); 
		  assertEquals("ApplesxxYYzz#", sc.next());
		  test = sc.nextLine();
		  assertTrue(test.contains("digit"));
		  


	}

	
}
