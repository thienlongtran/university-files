public class SeriesThread implements Runnable{
    private currentN n;
    private int end;
    private Series series;

    /**
	 * @param n The current n to calculate series at.
	 * @param end The ending point of the series.
	 * @param series The series to solve.
	 */
    public SeriesThread(currentN n, int end, Series series){
        this.n = n;
        this.end = end;
        this.series = series;
    }

    /**
	 * Calculates the series at a given n.
     * Adds the result of equation at given n to resultHolder.
	 */
    @Override
    public void run(){
        try{
            while(n.getN() <= end){
                resultHolder.add(series.computeValue(n.addN()));
                Thread.sleep(1);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}