import java.util.concurrent.atomic.AtomicBoolean;

public class Fork{
    private AtomicBoolean isAvailable;
    private int forkNumber;

    public Fork(int forkNumber){
        this.isAvailable = new AtomicBoolean(true);
        this.forkNumber = forkNumber;
    }

    public int getForkNumber(){
        return this.forkNumber;
    }

    //Returns true if fork hasn't been 'picked' up yet.
    public boolean isAvailable(){
        return isAvailable.get();
    }

    public synchronized void pickupFork(){
        isAvailable.set(false);
    }

    public synchronized void putdownFork(){
        isAvailable.set(true);
    }
}