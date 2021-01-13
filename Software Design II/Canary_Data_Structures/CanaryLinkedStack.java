import java.util.LinkedList;
import java.util.ListIterator;;

public class CanaryLinkedStack{
    private LinkedList<Canary> canaries;

    public CanaryLinkedStack(){
        canaries = new LinkedList<Canary>();
    }

    public void push(Canary canary){
        canaries.push(canary);
    }
    
    public Canary pop(){
        return canaries.pop();
    }

    public Canary peek(){
        return canaries.peek();
    }

    public boolean isEmpty(){
        return canaries.isEmpty();
    }

    public void printStack(){
        ListIterator<Canary> iter = canaries.listIterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}