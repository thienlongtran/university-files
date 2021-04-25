import java.util.concurrent.atomic.AtomicBoolean;

public class Waiter {

    //True when there is a philosopher trying to eat
    //Prevents multiple philosophers picking up fork at same time
    private AtomicBoolean aPhilosopherIsEating;

    public Waiter(){
        this.aPhilosopherIsEating = new AtomicBoolean(false);
    }

     //Allow the philosopher to eat if no other philosophers are eating
    public synchronized boolean askToEat(){
        if(aPhilosopherIsEating.get()){
            return false;
        }
        else if (!aPhilosopherIsEating.get()){
            aPhilosopherIsEating.set(true);
            return true;
        }
        else{
            return false;
        }
    }

    //Allow philosopher to tell waiter that they're finished eating
    public synchronized void finishedEating(){
        this.aPhilosopherIsEating.set(false);
    }
}
