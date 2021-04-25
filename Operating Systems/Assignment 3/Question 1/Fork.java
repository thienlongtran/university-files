import java.util.concurrent.atomic.AtomicBoolean;

public class Fork{
    private AtomicBoolean isAvailable;

    public Fork(){
        this.isAvailable = new AtomicBoolean(true);
        System.out.println(isAvailable);
    }

    //Returns true if fork hasn't been 'picked' up yet.
    public boolean isAvailable(){
        return isAvailable.get();
    }

    public void pickupFork(){
        if(isAvailable()){
            isAvailable.set(false);
        }
        else{
            System.out.println("Something went wrong. Fork is unavailable but pickupFork was called.");
        }
    }

    public void putdownFork(){
        if(!isAvailable()){
            isAvailable.set(true);
        }
        else{
            System.out.println("Something went wrong. Fork is available but putdownFork was called.");
        }
    }
}