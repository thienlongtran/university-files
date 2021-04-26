import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Philosopher implements Runnable{
    private Random rand;
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private long startTime;
    private Waiter waiter;
    private boolean threadShouldBeRunning;

    private long totalTimeThinking;
    private long totalTimeHungry;
    private long totalTimeEating;

    private long totalAmountThinking;
    private long totalAmountHungry;
    private long totalAmountEating;

    public Philosopher(Fork leftFork, Fork rightFork, int philosopherNumber, Waiter waiter){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.philosopherNumber = philosopherNumber;
        this.waiter = waiter;
        this.rand = new Random();
        this.startTime = System.currentTimeMillis();
        this.threadShouldBeRunning = true;
    }

    public long getTotalAmountHungry() {
        return totalAmountHungry;
    }

    public long getTotalTimeHungry() {
        return totalTimeHungry;
    }
    
    public long getTotalAmountEating() {
        return totalAmountEating;
    }

    public long getTotalTimeEating() {
        return totalTimeEating;
    }

    public long getTotalAmountThinking() {
        return totalAmountThinking;
    }

    public long getTotalTimeThinking() {
        return totalTimeThinking;
    }

    @Override
    public void run(){
        System.out.printf("Philosopher: %d, Time: %d ms, running\n", philosopherNumber, getCurrentTime());
        while(threadShouldBeRunning){
            eat();
        }
    }

    //Return elapsed time since philosopher was instantiated
    private long getCurrentTime(){
        return System.currentTimeMillis() - this.startTime;
    }

    private boolean pickupLeftFork(){
        //Pickup Left Fork
        if(leftFork.isAvailable()){
            leftFork.pickupFork();
            System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
            return true;
        }
        else{
            System.out.printf("Philosopher: %d, Time: %d ms, tried to pick up fork %d, it's unavailable\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
            return false;
        }
    }

    private boolean pickupRightFork(){
        //Pickup Right Fork (once Left Fork is also picked up)
        if(rightFork.isAvailable()){
            rightFork.pickupFork();
            System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
            return true;
        }
        else{
            leftFork.putdownFork();
            waiter.finishedEating();
            return false;
        }
    }

    private void think(){
        try{
            long thinkTime = 10;
            System.out.printf("Philosopher: %d, Time: %d ms, entering think state. Will think for %d ms\n", philosopherNumber, getCurrentTime(), thinkTime);
            totalTimeThinking = totalTimeThinking + thinkTime;
            totalAmountThinking = totalAmountThinking + 1;
            TimeUnit.MILLISECONDS.sleep(thinkTime);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        } 
    }


    //Philosopher is hungry
    private void eat(){
        while(threadShouldBeRunning){
            System.out.printf("Philosopher: %d, Time: %d ms, entering hungry state.\n", philosopherNumber, getCurrentTime());

            long startHungry = getCurrentTime();
            while(waiter.askToEat() == false){
                //do nothing while waiter doesn't allow philosopher to eat
            }

            if(pickupLeftFork()){
                //pass
            }
            else{
                continue;
            }

            if(pickupRightFork()){
                //pass
            }
            else{
                continue;
            }
            long timeHungry = getCurrentTime() - startHungry;
            totalTimeHungry = totalTimeHungry + timeHungry;
            totalAmountHungry = totalAmountHungry + 1;

            long eatTime = rand.nextInt(30) + 10;
            totalTimeEating = totalTimeEating + eatTime;
            totalAmountEating = totalAmountEating + 1;
            System.out.printf("Philosopher: %d, Time: %d ms, entering eating state. Will eat for %d ms\n", philosopherNumber, getCurrentTime(), eatTime);
            leftFork.putdownFork();
            rightFork.putdownFork();
            waiter.finishedEating();

            think();
        }
    }

    public void printTotalTimes(){
        System.out.printf("Philosopher %d total times:\n Hungry: %d ms\n Eating: %d ms\n Thinking: %d ms\n\n", philosopherNumber, totalTimeHungry, totalTimeEating, totalTimeThinking);
    }

    public void stopThread(){
        this.threadShouldBeRunning = false;
    }
}