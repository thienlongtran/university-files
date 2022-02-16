import java.math.BigDecimal;

public class resultHolder {
    private static BigDecimal result = new BigDecimal(0);

    /**
	 * Adds the number to the overall result
     * @param x the BigDecimal to add to result.
	 */
    public static synchronized void add(BigDecimal x){
        result = result.add(x);
    }

    /**
	 * Sets the value of the holder to zero.
	 */
    public static void setToZero(){
        result = new BigDecimal(0);
    }

    /**
	 * Retrives and returns the current value of result.
	 */
    public static BigDecimal get(){
        return result;
    }
}