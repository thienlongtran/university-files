import java.util.List;
import java.util.Vector;

public class CanaryVector{
    public static void main(String[] args){
        System.out.println();
        Canary blackCanary = new Canary("Black Canary", 1000);
        Canary whiteCanary = new Canary("White Canary", 500);
        Canary blackSiren = new Canary("Black Siren", 2000);

        List<Canary> canaries = new Vector<>();

        canaries.add(blackCanary);
        canaries.add(whiteCanary);
        canaries.add(blackSiren);
        canaries.add(1, new Canary("Talia", 5000));

        canaries.forEach(canary -> canary.setPowerLevel(canary.getPowerLevel() - 4));
    
        
        System.out.println(canaries.indexOf(new Canary("Talia", 4996)));

    }
}