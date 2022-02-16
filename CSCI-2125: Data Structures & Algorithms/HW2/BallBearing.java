/**
 * Ball-Bearing clsss meant to represent individual metal ball bearings in a ball clock
 * @param position the position in which an individual ball was created starting at 0.
*/

public class BallBearing{
    private int position;

    public BallBearing(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }
}