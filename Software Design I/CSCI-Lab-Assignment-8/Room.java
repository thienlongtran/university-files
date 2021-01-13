public class Room{
  private String name;
  private String description;
  private Room north;
  private Room south;
  private Room east;
  private Room west;

  public Room(String name, String description){
    this.name = name;
    this.description = description;
  }

  public void setExits(Room n, Room e, Room w, Room s){
    this.north = n;
    this.south = s;
    this.east = e;
    this.west = w;
  }

  public String getName(){
    return name;
  }

  public String getDescription(){
    return description;
  }

  public Room getNorth(){
    return this.north;
  }

  public Room getSouth(){
    return this.south;
  }

  public Room getEast(){
    return this.east;
  }

  public Room getWest(){
    return this.west;
  }

  public String getExits(){
    String tempString = "";

    try{
      tempString = tempString + String.format("\n[N]orth: %s", getNorth().name);
    }catch(Exception e){}

    try{
      tempString = tempString + String.format("\n[E]ast: %s", getEast().name);
    }catch(Exception e){}

    try{
      tempString = tempString + String.format("\n[W]est: %s", getWest().name);
    }catch(Exception e){}

    try{
      tempString = tempString + String.format("\n[S]outh: %s", getSouth().name);
    }catch(Exception e){}
    return tempString;
  }

  public String toString(){
    return String.format("[%s]\n%s%s", getName(), getDescription(),getExits());
  }
}