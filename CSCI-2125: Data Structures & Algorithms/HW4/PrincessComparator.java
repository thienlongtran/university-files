import java.util.Comparator;

public class PrincessComparator implements Comparator{

    @Override
    public int compare(Object x, Object y){

        Princess target1 = (Princess)x;
        Princess target2 = (Princess)y;

        return -(target1.getPowerLevel() - target2.getPowerLevel());
    }
}