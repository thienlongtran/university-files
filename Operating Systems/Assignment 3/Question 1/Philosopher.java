import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Philosopher implements Runnable{
    private Random rand;
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private long startTime;

    public Philosopher(Fork leftFork, Fork rightFork, int philosopherNumber){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.philosopherNumber = philosopherNumber;
        this.rand = new Random();
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run(){
        while(true){
            System.out.printf("Philosopher: %d, Time: %d ms, running\n", philosopherNumber, getCurrentTime());

            try{
                TimeUnit.MILLISECONDS.sleep(20);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //Return elapsed time since philosopher was instantiated
    private long getCurrentTime(){
        return System.currentTimeMillis() - this.startTime;
    }

    //Philosopher is hungry
    private void eat(){
        if(leftFork.isAvailable()){
            leftFork.pickupFork();
        }
        else{
            try{
                long time = rand.nextInt(25+1) + 25;
                System.out.println("Philosopher: %d");
                TimeUnit.MILLISECONDS.sleep(time);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            } 
        }
    }
}