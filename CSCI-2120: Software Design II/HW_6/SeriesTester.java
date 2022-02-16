import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

public class SeriesTester {
    private BigDecimal result1;
    private BigDecimal result2;

    @Before
    public void setup(){
        System.out.println();
        result1 = new BigDecimal(0);
        result2 = new BigDecimal(0);
    }

   @Test
    public void testSeriesTwo(){
        System.out.println("Testing Series Two - From n = 0 to 6000");
        System.out.println("This will take time");
        long startTime;
        long endTime;

        //Calculate concurrently
        startTime = System.currentTimeMillis();
		result1 = SeriesSolver.computeSum(Series.TWO, 0, 6000, 50);
		endTime = System.currentTimeMillis();
		System.out.println("Calculation w/ 50 Threads\nElapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println();

		//Calculate linearly
		startTime = System.currentTimeMillis();
		result2 = SeriesSolver.computeSum(Series.TWO, 0, 6000);
		endTime = System.currentTimeMillis();
        System.out.println("Calculation w/o Concurrency\nElapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
        assertEquals(result1,result2);
        System.out.println("Test Passed\n");
    }

    @Test
    public void testSeriesPI(){
        System.out.println("Testing Series PI - From n = 0 to 5000");
        long startTime;
        long endTime;

        //Calculate with threads
		startTime = System.currentTimeMillis();
		result1 = SeriesSolver.computeSum(Series.PI, 0, 5000, 50);
		endTime = System.currentTimeMillis();
		System.out.println("Calculation w/ 50 Threads\nElapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
		System.out.println();

		//Calculate linearly
		startTime = System.currentTimeMillis();
		result2 = SeriesSolver.computeSum(Series.PI, 0, 5000);
		endTime = System.currentTimeMillis();
        System.out.println("Calculation w/o Concurrency\nElapsed Time: "+(double)(endTime-startTime)/1000 + " seconds");
        assertEquals(result1,result2);
        System.out.println("Test Passed\n");

    }
}