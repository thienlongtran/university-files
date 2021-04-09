import java.lang.Math;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;

public class SeriesSolver {
	
	//General Runner for Debugging Purposes
	public static void main(String[] args){
		long startTime;
		long endTime;
		long n = 11195272402559238L;
		int sqrtn = (int)Math.sqrt(n) + 1;
		boolean result;

		//Calculate with one thread
		startTime = System.currentTimeMillis();
		result = isPrime(n);
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println("Is Prime: " + result);

		//Calculate with two threads
		startTime = System.currentTimeMillis();
		result = isPrime(n, 2);
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println("Is Prime: " + result);

	}
	
	/**
	 * Figure out if number is prime with only one thread.
	 */
	public static boolean isPrime(final long num){
		boolean result = true;

		for(int i = 2; i <= (int)Math.sqrt(num) + 1; i++){
			if(num % i == 0){
				result = false;
				break;
			}
		}

		return result;

	}
	
	/**
	 * Figure out if number is prime with multiple threads.
	 */
	public static boolean isPrime(final long num, final int threads){
		boolean result = true;

		//CurrentN holds the current index of the series
		currentN current = new currentN(1);

		//Arraylist holds each individual thread
		ArrayList<SeriesThread> threadsList= new ArrayList<SeriesThread>();

		//Create the number of threads that the user specifies
		for(int i = 0; i < threads; i++){
			SeriesThread newThread = new SeriesThread(current, num, result);
			threadsList.add(newThread);
		}

		ExecutorService seriesThreads = Executors.newCachedThreadPool();

		//Executes every thread in the ArrayList
		threadsList.forEach(thread -> seriesThreads.execute(thread));

		seriesThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!seriesThreads.isTerminated()){
			
		}

		return result;
	}

}