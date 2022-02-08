import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class PasswordCheckerUtility {

	
	
	
	//constructor
/*	public PasswordCheckerUtility() throws InvalidSequenceException, LengthException, NoDigitException, NoLowerAlphaException, NoUpperAlphaException {
			
		
		
	}
	*/
	/**
	 *  make sure all the passwords are valid if not throw exception

	 * @param password123
	 * @return
	 * @throws InvalidSequenceException
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoLowerAlphaException
	 * @throws NoUpperAlphaException
	 * @throws NoSpecialCharacterException
	 */
	public static boolean isValidPassword(String password123)  throws InvalidSequenceException, LengthException,  NoDigitException,  NoLowerAlphaException, NoUpperAlphaException, NoSpecialCharacterException
	{
		// TODO Auto-generated method stub
		
		return neededSequence(password123) && neededDigits(password123) && lowerCase(password123)  && hasUpperAlpha(password123) 
				&& hasSpecialCharacter(password123) && isValidLength(password123);
			
			
			
		}
		 
		
	/**
	 * 
	 * password is greater than 6 but <= 9
	 * 
	 * @param password123
	 * @return is the password is weak or not
	 * @throws NoSpecialCharacterException 
	 * @throws NoUpperAlphaException 
	 * @throws NoLowerAlphaException 
	 * @throws NoDigitException 
	 * @throws LengthException 
	 * @throws InvalidSequenceException 
	 */

	public static boolean isWeakPassword(String password123) throws InvalidSequenceException, LengthException, NoDigitException, NoLowerAlphaException, NoUpperAlphaException, NoSpecialCharacterException{
		// TODO Auto-generated method stub
		
		return (password123.length() < 10);
	}
	
	
	/**
	 * with arraylist having an invalid password
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		// TODO Auto-generated method stub


	    ArrayList<String> invalidPasswords = new ArrayList<>();
	    for (String str : passwords) {
	      try {
	        isValidPassword(str);
	      } catch (Exception e) {
	        invalidPasswords.add(str + " " + e.getMessage());
	      }
	    }
	    return invalidPasswords;
	    
	    
	}
	
	
	/**
	 * 
	 * 
	 * @param passwordString
	 * @return 
	 * @throws InvalidSequenceException
	 */
	  private static boolean neededSequence(String passwordString) throws InvalidSequenceException {
		  
		  
		    for (int i = 0; i < passwordString.length() - 2; i++) {
		    	
		      if (passwordString.charAt(i) == passwordString.charAt(i + 1)) {
		    	  
		        if (passwordString.charAt(i + 1) == passwordString.charAt(i + 2)) {
		        	
		          throw new InvalidSequenceException();
		          
		        }
		      }
		    }
		    
		    return true;
		  }
	  
	  
	  
	  /**
	   * passssword is greater than 6
	   * @param passwordString
	   * @return password is greater than 6
	   * @throws LengthException
	   */
	
	  static boolean isValidLength(String passwordString) throws LengthException {
		  
		if (passwordString.length() >= 6) {
			
			return true;
		}else {
			  
			throw new LengthException();
			
		    }
	  }
	  
	  
	  /**
	   * 
	   * 
	   * return atleast one digit
	   * 
	   * @param passwordString
	   * @return return atleast one digit
	   * @throws NoDigitException
	   */
	  private static boolean neededDigits(String passwordString) throws NoDigitException {
		  
		  
		  for (Character c : passwordString.toCharArray()) {
			  
		      if (Character.isDigit(c)) {
		        return true;
		        
		        
		      }
		      
		      
		    }
		    throw new NoDigitException();
		  }
	  
	  
	  /**
	   * returns a lower case letter
	   * 
	   * @param passwordString
	   * @return returns a lower case letter
	   * @throws NoLowerAlphaException
	   */
	  
	  private static boolean lowerCase(String passwordString) throws NoLowerAlphaException {
		  
		  
		    for (Character c : passwordString.toCharArray()) {
		    	
		    	
		      if (Character.isLowerCase(c)) {
		    	  
		    	  
		        return true;
		        
		      }
		      
		      
		    }
		    
		    throw new NoLowerAlphaException();
		  }
	
	  
	  
	  
	  /**
	   * returns atleast one upper case letter
	   * @param passwordString
	   * @return returns atleast one upper case letter
	   * @throws NoUpperAlphaException
	   */
	  static boolean hasUpperAlpha(String passwordString) throws NoUpperAlphaException {
		  
		  
		    for (Character c : passwordString.toCharArray()) {
		    	
		    	
		      if (Character.isUpperCase(c)) {
		    	  
		        return true;
		        
		      }
		      
		    }
		    throw new NoUpperAlphaException();
		  }
	  
	  
	  

	  /**
	   * return atleast one special character
	   * 
	   * @param passwordString
	   * @return return atleast one special character
	   * @throws NoSpecialCharacterException
	   */
	  
	  private static boolean hasSpecialCharacter(String passwordString) throws NoSpecialCharacterException {
		  
		  
		    Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		    Matcher matcher = pattern.matcher(passwordString);
		    
		    if (!matcher.find()) {
		    	
		    	
		      throw new NoSpecialCharacterException();
		    }
		    
		    return true;
		  }



/**
 * check if passwords are the same
 * @param passwordString
 * @param passwordAString
 * @return boolean password
 */
	public static boolean comparePasswordsWithReturn(String passwordString, String passwordAString) {
		// TODO Auto-generated method stub
		
		if(passwordString.equals(passwordAString)) {
			
			return true;
		}
		return false;
	}


/**
 * 
 * check if passwords are the same
 * @param password
 * @param passwordConfirm
 */

	public static void comparePasswords(String password, String passwordConfirm) {
		// TODO Auto-generated method stub
		if(password.equals(passwordConfirm)) {
			
			;
		}
		
	}





	  
	  
	  



}

