public class Canary{

    private String name;
    private int powerLevel;

    public Canary(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerLevel() {
        return this.powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public boolean equals(Object o){
        Canary obj = (Canary)o;

        if(this.getName().equals(obj.getName()) && this.getPowerLevel() == obj.getPowerLevel()){
            return true;
        }
        else{
            return false;
        }

        
    }
    
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", powerLevel='" + getPowerLevel() + "'" +
            "}";
    }

}