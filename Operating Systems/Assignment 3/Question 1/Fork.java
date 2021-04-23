import java.util.concurrent.atomic.AtomicBoolean;

public class Fork{
    private AtomicBoolean isAvailable;

    public Fork(){
        this.isAvailable = new AtomicBoolean(true);
        System.out.println(isAvailable);
    }
}