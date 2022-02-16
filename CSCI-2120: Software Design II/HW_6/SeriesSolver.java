import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;

/**
 * Utility class that computes approximations of series.
 */
public class SeriesSolver {
	
	//General Runner for Debugging Purposes
	public static void main(String[] args){
		BigDecimal result;
		long startTime;
		long endTime;

		//Calculate with threads
		startTime = System.currentTimeMillis();
		result = computeSum(Series.PI, 0, 5000, 50);
		endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Elapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println();

		//Calculate linearly
		startTime = System.currentTimeMillis();
		result = computeSum(Series.PI, 0, 5000);
		endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Elapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");

	}
	
	/**
	 * Computes the series sequentially using only one thread.
	 *
	 * @param series The Series to solve.
	 * @param a The min n value to iterate to.
	 * @param b The max n value to iterate to.
	 * @return The sum of the series from a to b.
	 */
	public static BigDecimal computeSum(final Series series, final int a, final int b){
		if (a > b){
			throw new IllegalArgumentException("a cannot be greater than b.");
		}
		BigDecimal sum = new BigDecimal(0);
		for (int n = a; n <= b; n++){
			sum = sum.add(series.computeValue(n));
		}
		return sum;
	}
	
	/**
	 * Computes the series using multiple threads.
	 *
	 * @param series The Series to solve.
	 * @param a The min n value to iterate to.
	 * @param b the max n value to iterate to.
	 * @param threads The number of threads to use (can be less if b-a is small).
	 * @return The sum of the series from a to b.
	 */
	public static BigDecimal computeSum(final Series series, final int a, final int b, final int threads){
		if (a > b){
			throw new IllegalArgumentException("a cannot be greater than b.");
		}
		if (threads <= 0){
			throw new IllegalArgumentException("Number of threads must be positive.");
		}
		
		//CurrentN holds the current index of the series
		currentN current = new currentN(a);

		//Arraylist holds each individual thread
		ArrayList<SeriesThread> threadsList= new ArrayList<SeriesThread>();

		//Dumps resultHolder of any previous calculation
		resultHolder.setToZero();

		//Create the number of threads that the user specifies
		for(int i = 0; i < threads; i++){
			SeriesThread newThread = new SeriesThread(current,b,series);
			threadsList.add(newThread);
		}

		ExecutorService seriesThreads = Executors.newCachedThreadPool();

		//Executes every thread in the ArrayList
		threadsList.forEach(thread -> seriesThreads.execute(thread));

		seriesThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!seriesThreads.isTerminated()){
		
		}

		return resultHolder.get();
	}

}