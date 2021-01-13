import java.util.LinkedList;
import java.util.Iterator;

public class CanaryLinkedList{
    public static void main(String[] args){
        System.out.println();
        Canary blackCanary = new Canary("Black Canary", 1000);
        Canary whiteCanary = new Canary("White Canary", 500);
        Canary blackSiren = new Canary("Black Siren", 2000);

        LinkedList<Canary> canaries = new LinkedList<Canary>();

        canaries.addFirst(blackCanary);
        canaries.addFirst(whiteCanary);
        canaries.addFirst(blackSiren);
        canaries.addFirst(new Canary("Talia", 5000)); 
        canaries.addLast(new Canary("Mia", 250));

        canaries.removeFirst();

        Iterator iter = canaries.iterator();
        
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        

    }
}