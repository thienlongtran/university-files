public class Operations {
	
	public static int add(int x, int y) {
		return x+y;
	}
	
	public static int subtract(int x, int y) {
		return x-y;
	}
	
	public static int multiply(int x, int y) {
		return x*y;
	}
	
	public static int divide(int x, int y) {
		//#TODO
		//if the denominator is 0, throw an ArithemeticException
		//containing the error message "Divide by 0!" as its argument 
		if (y == 0){
			throw new ArithmeticException("Divide by 0!");
		}
		
		return x/y;
	}
}
