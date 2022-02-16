import java.util.Scanner;

/** 
*clockRunner manages the inputs (amount of balls in clock) of the user and outputs the result of how long it takes for a ball clock to cycle in days. 
*/
public class clockRunner{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            int initialBallAmount = input.nextInt();

            //Zero signals end of input
            if(initialBallAmount == 0){
		        System.out.println("End of text detected. Goodbye!");
                break;
            }

            //Initialize and start the clock
            BallClock newClock = new BallClock(initialBallAmount);
            newClock.startClock();
            System.out.printf("%s balls cycle after %s days.\n", initialBallAmount, newClock.getResult());
        }
    }
}