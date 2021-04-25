import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Runner{
    public static void main(String[] args){
        Fork F0 = new Fork();
        Fork F1 = new Fork();
        Fork F2 = new Fork();
        Fork F3 = new Fork();

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

    }
}