public class GeneralCanaryRunner{
    public static void main(String[] args) {
        CanaryArrayQueue canaryArray  = new CanaryArrayQueue(1);

        Canary blackCanary = new Canary("Black Canary", 1000);
        Canary whiteCanary = new Canary("White Canary", 500);
        Canary blackSiren = new Canary("Black Siren", 2000);
        
        canaryArray.add(blackCanary);
        canaryArray.add(whiteCanary);
        canaryArray.add(blackSiren);

        canaryArray.printStack();

        canaryArray.remove();
        canaryArray.printStack();
    }
}