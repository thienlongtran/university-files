import java.lang.Math;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrimeSolver {
	
	//General Runner for Debugging Purposes
	public static void main(String[] args){
		long startTime;
		long endTime;
		long n = 72980630856892961L;

		//Calculate with one thread
		boolean result;
		startTime = System.currentTimeMillis();
		result = isPrime(n);
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - One Thread: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println("Is Prime: " + result);

		//Calculate with two threads
		AtomicBoolean twoThreadResult = new AtomicBoolean();
		startTime = System.currentTimeMillis();
		twoThreadResult = isPrimeTwoThreads(n);
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - Two Threads: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println("Is Prime: " + twoThreadResult.get());

		//Calculate with three threads
		AtomicBoolean threeThreadResult = new AtomicBoolean();
		startTime = System.currentTimeMillis();
		threeThreadResult = isPrimeThreeThreads(n);
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - Three Threads: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println("Is Prime: " + threeThreadResult.get());

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
	 * Figure out if number is prime with two threads.
	 */
	public static AtomicBoolean isPrimeTwoThreads(final long num){
		AtomicBoolean result = new AtomicBoolean(true);
		int sqrtN = (int)Math.sqrt(num) + 1;

		PrimeThread thread1 = new PrimeThread(num, result, 2, sqrtN/2);
		PrimeThread thread2 = new PrimeThread(num, result, sqrtN/2, sqrtN);

		ExecutorService seriesThreads = Executors.newCachedThreadPool();

		//Start each thread
		seriesThreads.execute(thread1);
		seriesThreads.execute(thread2);

		seriesThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!seriesThreads.isTerminated()){
			
		}

		return result;
	}

	/**
	 * Figure out if number is prime with three threads.
	 */
	public static AtomicBoolean isPrimeThreeThreads(final long num){
		AtomicBoolean result = new AtomicBoolean(true);
		int sqrtN = (int)Math.sqrt(num) + 1;

		int oneThirds = sqrtN / 3;
		int twoThirds = oneThirds * 2;

		PrimeThread thread1 = new PrimeThread(num, result, 2, oneThirds);
		PrimeThread thread2 = new PrimeThread(num, result, oneThirds, twoThirds);
		PrimeThread thread3 = new PrimeThread(num, result, twoThirds, sqrtN);

		ExecutorService seriesThreads = Executors.newCachedThreadPool();

		//Start each thread
		seriesThreads.execute(thread1);
		seriesThreads.execute(thread2);
		seriesThreads.execute(thread3);

		seriesThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!seriesThreads.isTerminated()){
			
		}

		return result;
	}

}