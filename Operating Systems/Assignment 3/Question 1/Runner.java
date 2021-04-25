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

        System.out.println("60 seconds elapsed. Program finished.");
        System.setOut(console);
        P0.printTotalTimes();
        P1.printTotalTimes();
        P2.printTotalTimes();
        P3.printTotalTimes();
        System.exit(0);
        

    }
}