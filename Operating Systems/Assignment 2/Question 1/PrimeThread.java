import java.util.concurrent.atomic.AtomicBoolean;

public class PrimeThread implements Runnable{
    private long num;
    public AtomicBoolean result;
    private int start;
    private int end;

    /**
	 * @param num The number to check if prime or not.
     * @param result Stores result of if number is prime.
     * @param start The number to start checking at.
     * @param end The number to stop checking at.
	 */
    public PrimeThread(long num, AtomicBoolean result, int start, int end){
        this.num = num;
        this.result = result;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
            for (int i = start; i <= end; i++){

                //a thread determined that number is not prime - current thread can stop executing
                if(result.get() == false){
                    break;
                }

                //check if num is prime
                if(num % i == 0){
                    result.getAndSet(false);
                    System.out.println("This came true - result is: "+ result.get());
                    break;   
                }
            }
    }
}