import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * General purpose runner for creating the seperate threads and executing them.
 */
public class Runner {
    public static void main(String[] args){
        ArrayList<HeapCalculationThread> threadsList= new ArrayList<HeapCalculationThread>();

        HeapCalculationThread newThread1 = new HeapCalculationThread("insert", "ordered");
        HeapCalculationThread newThread2 = new HeapCalculationThread("buildheap", "ordered");

        threadsList.add(newThread1);
        threadsList.add(newThread2);

        ExecutorService heapCalculationThreads = Executors.newCachedThreadPool();
        threadsList.forEach(thread -> heapCalculationThreads.execute(thread));
        heapCalculationThreads.shutdown();
    }
}