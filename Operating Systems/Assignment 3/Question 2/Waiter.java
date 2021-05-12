import java.util.concurrent.atomic.AtomicBoolean;

public class Waiter {
    //Index of philosopher name is true when that philosopher is eating.
    private boolean[] semaphore;

    public Waiter(){
       semaphore = new boolean[4]; //initialize AtomicBoolean array with all values false.
    }

     //Philosopher uses this function to ask the waiter/semaphore if they can eat.
    public synchronized boolean askToEat(int philosopherNumber){
        int leftPhilosopherNumber = 0;//(philosopherNumber + 1) % 3;
        int rightPhilosopherNumber = 1;//(philosopherNumber - 1) % 3;

        //Allow philosopher to eat if their neighbors are not currently eating.
        if(semaphore[leftPhilosopherNumber] == false && semaphore[rightPhilosopherNumber] == false){
            semaphore[philosopherNumber] = true;
            return true;
        }

        //Prevent philosopher from eating if one of their neighbors are eating.
        else{
            return false;
        }
    }

    //Allow philosopher to tell waiter/semaphore that they're finished eating.
    public synchronized void finishedEating(int philosopherNumber){
        semaphore[philosopherNumber] = false;
    }
}
