import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * Test class for MorseCodeTree
 * @author Chris Tark
 *
 */
public class MorseCodeTreeTest_Chris_Tark {

	MorseCodeTree mct = new MorseCodeTree();
	
	@Before
	public void setup() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{

	}
	
	/**
	 * Testing MorseCodeConverter
	 */
	@Test
	public void stringConvertToEnglish_Tark() {
		
		String converter1 = MorseCodeConverter.convertToEnglish(".. / .-- .- -. - / .- / .--. ..- .--. .--. -.-- ");
		assertEquals("i want a puppy",converter1);
	}
	
	/**
	 * Testing MorseCodeConverter
	 */
	@Test
	public void fileConvertToEnglish_Tark() {
		
		File file = new File("src/Monkey.txt"); 
		
		try {
			
			assertEquals("monkey see monkey do", MorseCodeConverter.convertToEnglish(file));
			
		} catch (FileNotFoundException e) {
			
			assertTrue("An unwanted exception was caught", false);
		}
	}
	
	@Test
	public void getRootTest() {
		
		//get reference of node
		TreeNode<String> test = mct.getRoot();
		//System.out.println(test);
		assertTrue(test.toString().startsWith("TreeNode@"));
	}
	
	
	@Test
	public void fetchTest() {
		
		String fetch1 = mct.fetch("-");
		assertEquals("t", fetch1);
		
		String fetch2 = mct.fetch("-..-");
		assertEquals("x", fetch2);
		
		String fetch3 = mct.fetch("-.-.");
		assertEquals("c", fetch3);
	}
	
	
	@Test
	public void deleteTest() {
		
		try {
			
			mct.delete("a");

		} catch (UnsupportedOperationException e) {
			
			assertEquals(e.getMessage(), "Delete is not supported in MorseCodeTree");
		}
		
		
	}
	
	@Test 
	public void updateTest() {
		
		try {
			
			mct.update();
			
		} catch (UnsupportedOperationException e) {
			
			assertEquals(e.getMessage(), "Update is not supported in MorseCodeTree");
		}
		
	}
	
	@Test
	public void toArrayListTest() {
		
		assertEquals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]", mct.toArrayList().toString());
		
	}
}
