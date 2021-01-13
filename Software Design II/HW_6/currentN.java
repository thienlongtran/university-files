public class currentN {
    private int n;

    /**
	 * Thread-safe way to save the current position of a series
	 * @param n The current index of series.
	 */
    public currentN(int n){
        this.n = n;
    }

    /**
	 * Returns n WITHOUT incrementing it.
	 * @return The current position of n.
	 */
    public int getN(){
        return this.n;
    }
    
    /**
	 * Increments the index of series.
	 * @return The current position of n.
	 */
    public synchronized int addN(){
        return this.n++;
    }
}

