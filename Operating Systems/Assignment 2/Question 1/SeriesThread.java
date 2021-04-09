public class SeriesThread implements Runnable{
    private currentN n;
    private long num;
    private boolean result;

    /**
	 * @param n The current n to calculate at.
	 */
    public SeriesThread(currentN n, long num, boolean result){
        this.n = n;
        this.num = num;
        this.result = result;
    }

    /**
	 * Calculates the series at a given n.
	 */
    @Override
    public void run(){
        try{
            int currentN = n.addN();
            while(result == true && currentN <= (int)Math.sqrt(num) + 1){
                if(num % currentN == 0){
                    result = false;
                    break;
                }
                System.out.println("Test");
                Thread.sleep(1);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}