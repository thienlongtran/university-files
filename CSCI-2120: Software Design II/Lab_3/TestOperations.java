import org.junit.*;//Makes JUnit (annotations etc.) work
import static org.junit.Assert.*;//Makes asserts work. Note, Assert methods are static

public class TestOperations {
	
	private int result;
	private int maxValue = Integer.MAX_VALUE;//2,147,483,647
	private int minValue = Integer.MIN_VALUE;//-2,147,483,648
		
	@Before
	public void setUp(){
		result = 0;
	}
	
	@Test
	public void testAdd(){
		System.out.println("Result testAdd: " + result);
		result = Operations.add(5, 3);
		assertTrue(result == 8);
		result = Operations.add(maxValue, 1);
		assertEquals(result, minValue);
		assertFalse((Operations.add(maxValue, 1)) > 0);
		System.out.println("Result testAdd: " + result);
	}
	

	@Test
	public void testSubtract(){
		System.out.println("Result testSubtract: " + result);
		result = Operations.subtract(5, 3);
		assertTrue(result == 2);
		result = Operations.subtract(minValue, 1);
		assertEquals(result, maxValue);
		assertFalse((Operations.subtract(minValue, 1)) < 0);
		System.out.println("Result testSubtract: " + result);
	}
	
	
	@Test
	public void testMultiply(){
		System.out.println("Result testMultiply: " + result);
		result = Operations.multiply(5, 3);
		assertTrue(result == 15);
		result = Operations.multiply(1073741824, 2);
		assertEquals(result, minValue);
		assertFalse((Operations.multiply(1073741824, 2)) > 0);
		System.out.println("Result testMultiply: " + result);
	}
	
	
	@Test
	public void testDivide(){
		
		result = Operations.divide(5, 3);
		assertTrue(result == 1);
		
		String errorMessage = "";
		
		try {
			Operations.divide(3, 0);
		} catch (ArithmeticException e) {
			errorMessage = e.getMessage();
		}
		
		System.out.println(errorMessage);
		assertTrue(errorMessage.equals("Divide by 0!"));
	}

}
