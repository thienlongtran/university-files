public class Recursion {

	public static void main(String[] args) {
		System.out.println("Fibonacci: " + fibonacci(10));
		System.out.println("Factorial: " + factorial(5));
		System.out.println(stringIterator("Beware M. Bison's psycho power!"));

	}
	
	public static int fibonacci(int nthTerm) {
		if (nthTerm == 0 || nthTerm == 1) {
			return nthTerm;
		} else {
			return fibonacci(nthTerm-1) + fibonacci(nthTerm-2);
		}
	}

	public static int factorial(int n) {
		if(n==0){
			return 1;
		}
		else{
			System.out.println("n: " + n);
			return n * factorial(n-1);
		}
	}

	public static char stringIterator(String string) {		
		if (string.charAt(string.length()-1) == 'M') {
			return 'M';
		} else {
			System.out.println(string);//Keep this line
			return stringIterator(string.substring(0,string.length()-1));
		}
	}
}
