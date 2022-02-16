import java.util.LinkedList;

/**
 * A Linked-List backed queue for the ball clock.
 * Ball Clock Operation: Max of 4 balls on the minuteQueue, 11 balls on the fifteenMinuteQueue, and 11 balls on hourQueue.
 * Each queue represents a block of time by their respective name.
 * Clock starts at 1:00 (When all balls are on the mainQueue).
 * @param size the amount of balls in the Ball Clock.
 */

public class BallClock{
    private int initialSize;
    private int result;
    private LinkedList<BallBearing> mainQueue = new LinkedList<BallBearing>();
    private LinkedList<BallBearing> minuteQueue = new LinkedList<BallBearing>();
    private LinkedList<BallBearing> fiveMinuteQueue = new LinkedList<BallBearing>();
    private LinkedList<BallBearing> hourQueue = new LinkedList<BallBearing>();

    public BallClock(int size){
        this.initialSize = size;

        for(int i = 0; i < size; i++){
            this.mainQueue.add(new BallBearing(i));
        }
    }

    /**
     * Starts the clock. Ends when the cycle is complete and the result is sucessfully calculated.
     */
    public void startClock(){


        //Starting condition so that while-loop below could run.
        nextBall();
        result = 1;

        //Runs while the cycle isn't complete.
        while(!checkCycle()){
            nextBall();
            result++;
        }
    }

    /**
     * Checks if the cycle is done. Cycle is done if all of the balls are in order.
     * @return true if all of the balls are in order.
     */
    public boolean checkCycle(){
        int startingPosition = 0;

        for(BallBearing ball : getMainQueue()){
            if (ball.getPosition() == startingPosition){
                //Ball is in position - check next ball
                startingPosition++;
            }
            else{
                //Ball is not in position and cycle isn't done
                return false;
            }
        }
        return true;
    }

    /**
     * Drops all of the balls of a queue in reverse-order to the main queue.
     * Represents the capacity of a specific queue in a ball clock being reached and its balls dropped.
     * @param queue the specific queue to drop balls.
     */
    public void dropBalls(LinkedList<BallBearing> queue){
        while(queue.peek() != null){
            mainQueue.add(queue.pollLast());
        }
    }

    /**
     * Moves a single ball through the queue.
     * Represents a minute passing on a ball clock.
     * Handles the "dropping" of the balls once each queue is max capacity.
     */
    public void nextBall(){
        minuteQueue.add(mainQueue.pop());
        
        if(minuteQueue.size() == 5){
            //Minute Queue capacity reached
            fiveMinuteQueue.add(minuteQueue.pollLast()); //Move the most recent ball to the five minute queue
            dropBalls(minuteQueue); //Drop all other balls to main queue
        }

        if(fiveMinuteQueue.size() == 12){
            //Five Minute Queue capacity reached
            hourQueue.add(fiveMinuteQueue.pollLast()); //Move the most recent ball to the hour minute queue
            dropBalls(fiveMinuteQueue); //Drop all other balls to main queue
        }

        if(hourQueue.size() == 12){
            //Hour Queue capacity reached
            BallBearing lastBall = hourQueue.pollLast(); //Hold last ball to add to end of mainQueue instead of reverse-order
            dropBalls(hourQueue); //Drop balls to main queue
            mainQueue.add(lastBall);
        }
    }

    public LinkedList<BallBearing> getMainQueue(){
        return this.mainQueue;
    }

    public LinkedList<BallBearing> getMinuteQueue(){
        return this.minuteQueue;
    }

    public LinkedList<BallBearing> getFiveMinuteQueue(){
        return this.fiveMinuteQueue;
    }

    public LinkedList<BallBearing> getHourQueue(){
        return this.hourQueue;
    }

    /**
     * Takes the calculated result (in minutes) and returns the results (in days).
     * @return result (in days).
     */
    public int getResult(){
        return result/1440;
    }
}