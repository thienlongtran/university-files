import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Runner{
    public static void main(String[] args) throws FileNotFoundException{

        //Citation: Learned how to save outputs to a file from GeeksForGeeks
        //Link: https://www.geeksforgeeks.org/redirecting-system-out-println-output-to-a-file-in-java/

        PrintStream output = new PrintStream(new File("Output.txt"));
        PrintStream console = System.out;
        System.out.println("Starting program - program will run for 60 seconds.");
        System.out.println("Program running - please wait...");
        System.setOut(output);

        Fork F0 = new Fork(0);
        Fork F1 = new Fork(1);
        Fork F2 = new Fork(2);
        Fork F3 = new Fork(3);

        Philosopher P0 = new Philosopher(F0, F3, 0);
        Philosopher P1 = new Philosopher(F1, F0, 1);
        Philosopher P2 = new Philosopher(F2, F1, 2);
        Philosopher P3 = new Philosopher(F3, F2, 3);

        ExecutorService philosopherThreads = Executors.newCachedThreadPool();
        philosopherThreads.execute(P0);
        philosopherThreads.execute(P1);
        philosopherThreads.execute(P2);
        philosopherThreads.execute(P3);
        philosopherThreads.shutdown();

        //Wait 60 seconds for program to run
        try{TimeUnit.SECONDS.sleep(60);}
        catch(InterruptedException e){e.printStackTrace();}

        P0.stopThread();
        P1.stopThread();
        P2.stopThread();
        P3.stopThread();

        //Wait 50 milliseconds to clear any excess printing from philosopher threads
        try{TimeUnit.MILLISECONDS.sleep(50);}
        catch(InterruptedException e){e.printStackTrace();}

        System.setOut(console);
        System.out.println("60 seconds elapsed. Program finished.");

        P0.printTotalTimes();
        P1.printTotalTimes();
        P2.printTotalTimes();
        P3.printTotalTimes();

        //Print average time in hungry state
        long totalAmountHungry = P0.getTotalAmountHungry() + P1.getTotalAmountHungry() + P2.getTotalAmountHungry() + P3.getTotalAmountHungry();
        long totalTimeHungry = P0.getTotalTimeHungry() + P1.getTotalTimeHungry() + P2.getTotalTimeHungry() + P3.getTotalTimeHungry();
        System.out.println("Average time hungry: " + ( (double)totalTimeHungry) / (double)totalAmountHungry );

        //Print average time in eating state
        long totalAmountEating = P0.getTotalAmountEating() + P1.getTotalAmountEating() + P2.getTotalAmountEating() + P3.getTotalAmountEating();
        long totalTimeEating = P0.getTotalTimeEating() + P1.getTotalTimeEating() + P2.getTotalTimeEating() + P3.getTotalTimeEating();
        System.out.println("Average time eating: " + ( (double)totalTimeEating) / (double)totalAmountEating );

        //Print average time in thinking state
        long totalAmountThinking = P0.getTotalAmountThinking() + P1.getTotalAmountThinking() + P2.getTotalAmountThinking() + P3.getTotalAmountThinking();
        long totalTimeThinking = P0.getTotalTimeThinking() + P1.getTotalTimeThinking() + P2.getTotalTimeThinking() + P3.getTotalTimeThinking();
        System.out.println("Average time thinking: " + ( (double)totalTimeThinking) / (double)totalAmountThinking );

        System.exit(0);
        

    }
}