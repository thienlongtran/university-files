import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Philosopher implements Runnable{
    private Random rand;
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private long startTime;
    private Waiter waiter;

    public Philosopher(Fork leftFork, Fork rightFork, int philosopherNumber, Waiter waiter){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.philosopherNumber = philosopherNumber;
        this.waiter = waiter;
        this.rand = new Random();
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run(){
        System.out.printf("Philosopher: %d, Time: %d ms, running\n", philosopherNumber, getCurrentTime());
        while(true){
            System.out.printf("Philosopher: %d, Time: %d ms, entering hungry state\n", philosopherNumber, getCurrentTime());
            pickupLeftFork();
            pickupRightFork();
            think();
        }
    }

    //Return elapsed time since philosopher was instantiated
    private long getCurrentTime(){
        return System.currentTimeMillis() - this.startTime;
    }

    private void pickupLeftFork(){
        //Pickup Left Fork
        if(leftFork.isAvailable()){
            leftFork.pickupFork();
            System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
        }
        else{
            System.out.printf("Philosopher: %d, Time: %d ms, tried to pick up fork %d, it's unavailable\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
        }
    }

    private void pickupRightFork(){
        //Pickup Right Fork (once Left Fork is also picked up)
        if(rightFork.isAvailable()){
            rightFork.pickupFork();
            System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
            long eatTime = rand.nextInt(30) + 10;
            System.out.printf("Philosopher: %d, Time: %d ms, entering eating state. Will eat for %d ms\n", philosopherNumber, getCurrentTime(), eatTime);
            leftFork.putdownFork();
            rightFork.putdownFork();
            waiter.finishedEating();
        }
        else{
            leftFork.putdownFork();
            waiter.finishedEating();
        }
    }

    private void think(){
        try{
            long thinkTime = 10;
            System.out.printf("Philosopher: %d, Time: %d ms, entering think state. Will think for %d ms\n", philosopherNumber, getCurrentTime(), thinkTime);
            TimeUnit.MILLISECONDS.sleep(thinkTime);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        } 
    }


    //Philosopher is hungry
    private void eat(){
        while(true){
            System.out.printf("Philosopher: %d, Time: %d ms, entering hungry state.\n", philosopherNumber, getCurrentTime());

            while(waiter.askToEat() == false){
                //do nothing while waiter doesn't allow philosopher to eat
            }
            
            pickupLeftFork();
            pickupRightFork();
            think();
        }
    }
}