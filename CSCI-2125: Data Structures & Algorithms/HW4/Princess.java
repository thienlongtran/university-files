/**
 * Disney princess object for use in the heap.
 */

public class Princess implements Comparable{
    private String name;
    private int powerLevel;

    public Princess(String name, int powerLevel){
        this.name = name;
        this.powerLevel = powerLevel;
    }

    public String getName(){
        return this.name;
    }

    public int getPowerLevel(){
        return this.powerLevel;
    }

    @Override
    public int compareTo(Object other){
        Princess otherPrincess = (Princess)other;
        return this.powerLevel - otherPrincess.getPowerLevel();
    }

    @Override
    public String toString(){
        return this.name + ", Power Level: " + this.powerLevel;
    }
}