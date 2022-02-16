import java.util.Scanner;
import java.util.Random;

class BourbonStreetDungeonGame{
  public static void main(String[] args) {
    int random;
    String dir;

    System.out.println();
    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    System.out.println("You are a drunk girl who has been partying all night on Bourbon Street.");
    System.out.println("You were walking down the street when all the sudden you need to pee.");
    System.out.println("You don't want to pee on the streets like all of the sleazy guys.");
    System.out.println("You have one mission: to look for a safe bathroom.");
    System.out.println("Bourbon Street has many streets that are perpendicular to it.\nEach section that is shown to you is the section of Bourbon that is between two of those streets.");
    System.out.println("Directions: Enter 'n', 's', 'e', and 'w' to go North, South, East, and West respectively.");
    System.out.println();
    System.out.println("You start off at the section of Bourbon Street between Saint Ann Street and Orleans Street");


    //NEWS
    Room AnnOrleans = new Room("St Ann and Orleans", "There is a strange man looking at you suspiciously. Best get out of this area.");
    Room NapoleonsItch = new Room("Napoleon's Itch Night Club", "You notice a sign saying that the bathroom here is closed.");
    Room Fritzels = new Room("Fritzel's European Jazz Pub", "The bathroom is on the second floor. You're too drunk to walk up.");

    Room PeterOrleans = new Room("Orleans and St Peter", "There are frat guys on top of one of the buildings calling you to lift your shirt up.");
    Room BourbonHeat = new Room("Bourbon Heat", "You see a bathroom on the other side of the room, but there is suspicous 'sauce' on the ground that you'd rather not get close to.");
    Room Cornet = new Room("Cornet", "This is a fine dining steakhouse and the employees won't let you get past the lobby. No bathroom here.");

    Room DumaineAnn = new Room("Dumaine and St Ann", "The smell of throw up and regret fills the air.");
    Room Blacksmith = new Room("Lafitte's Blacksmith Shop Bar", "You forgot your mission and decided to order more drinks.");
    Room Poboy = new Room ("NOLA Poboys", "You were so hungry that you just ordered a poboy and forgot to use the restroom.");

    AnnOrleans.setExits(Fritzels, DumaineAnn, PeterOrleans, NapoleonsItch);
    NapoleonsItch.setExits(AnnOrleans, null, null, null);
    Fritzels.setExits(null, null, null, AnnOrleans);

    PeterOrleans.setExits(BourbonHeat, AnnOrleans, null, Cornet);
    BourbonHeat.setExits(null, null, null, PeterOrleans);
    Cornet.setExits(PeterOrleans, null, null, null);

    DumaineAnn.setExits(Blacksmith, null, AnnOrleans, Poboy);
    Blacksmith.setExits(null, null, null, DumaineAnn);
    Poboy.setExits(DumaineAnn, null, null, null);

    Room currentRoom = AnnOrleans;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    while (true){
      random = rand.nextInt(9);
      System.out.println(currentRoom);
      dir = input.nextLine();
      currentRoom = goDirection(dir, currentRoom);
      System.out.println();

      if(random == 4){
        System.out.println("After wandering around for so long, you needed to pee so bad that in the end, you decided to go to an alleyway and do it there.");
        break;

      }

    }

  }

  public static Room goDirection(String dir, Room currentRoom){
    dir = dir.toLowerCase();
    if (dir.equals("n") && currentRoom.goNorth == true){
      return currentRoom.getNorth();
    }
    
    else if (dir.equals("s") && currentRoom.goSouth == true){
      return currentRoom.getSouth();
    }

    else if (dir.equals("e") && currentRoom.goEast == true){
      return currentRoom.getEast();
    }

    else if (dir.equals("w") && currentRoom.goWest == true){
      return currentRoom.getWest();
    }

    else{
      System.out.println("Invalid Direction. Try Again.");
      return currentRoom;
    }
  }
}
