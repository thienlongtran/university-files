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
        System.out.printf("Philosopher: %d, Time: %d ms, running\n", philosopherNumber, getCurrentTime());
        while(true){
            try{
                eat();
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

    private void pickupLeftFork(){
        //Pickup Forks Loop
        while(true){
            //Pickup Left Fork
            if(leftFork.isAvailable()){
                leftFork.pickupFork();
                System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
                break;
            }
            else{
                try{
                    long time = rand.nextInt(50) + 50;
                    System.out.printf("Philosopher: %d, Time: %d ms, tried to pick up fork %d, it's unavailable\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
                    TimeUnit.MILLISECONDS.sleep(time);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } 
            }
        }
    }

    private void pickupRightFork(){
        //Pickup Right Fork (once Left Fork is also picked up)
        try{
            if(rightFork.isAvailable()){
                rightFork.pickupFork();
                System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
                long eatTime = rand.nextInt(30) + 10;
                System.out.printf("Philosopher: %d, Time: %d ms, entering eating state. Will eat for %d ms\n", philosopherNumber, getCurrentTime(), eatTime);
                TimeUnit.MILLISECONDS.sleep(eatTime);
                leftFork.putdownFork();
                rightFork.putdownFork();
            }
            else{
                    long time = rand.nextInt(50) + 50;
                    System.out.printf("Philosopher: %d, Time: %d ms, tried to pick up fork %d, it's unavailable\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
                    TimeUnit.MILLISECONDS.sleep(time);

                    //try to "pick up fork again" - start 'eating' when both forks are picked up
                    if(rightFork.isAvailable()){
                        rightFork.pickupFork();
                        System.out.printf("Philosopher: %d, Time: %d ms, picked up fork %d\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
                        long eatTime = rand.nextInt(30) + 10;
                        System.out.printf("Philosopher: %d, Time: %d ms, entering eating state. Will eat for %d ms\n", philosopherNumber, getCurrentTime(), eatTime);
                        TimeUnit.MILLISECONDS.sleep(eatTime);
                        leftFork.putdownFork();
                        rightFork.putdownFork();
                    }

                    //drop the leftFork on second failed attempt
                    else{
                        long sleepTime = rand.nextInt(50) + 50;
                        System.out.printf("Philosopher: %d, Time: %d ms, tried to pick up fork %d, it's unavailable\n", philosopherNumber, getCurrentTime(), rightFork.getForkNumber());
                        leftFork.putdownFork();
                        System.out.printf("Philosopher: %d, Time: %d ms, dropped fork %d\n", philosopherNumber, getCurrentTime(), leftFork.getForkNumber());
                        TimeUnit.MILLISECONDS.sleep(sleepTime);
                    }
                }
        }
        catch(InterruptedException e){
            e.printStackTrace();
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
            pickupLeftFork();
            pickupRightFork();
            think();
        }
    }
}