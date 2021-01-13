import java.util.Scanner;
import java.util.Random;

class NorthKoreaDungeonGame{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    //Rooms
    String[][] Rooms = {
      {null, null, "Guards' Room", null},
      {null, "Bath Room", "Conference Room", "Guest Bedroom"},
      {"Garage", "Weapons Room", "Center Lobby", "Kitchen"},
      {null, "Gym", "Kim's Room", "Dining Room"}
    };

    //Methods of Death
    String[] Death = {"strangling", "poisoning", "shooting", "cutting"};


    //Introduction Background
    System.out.println("\nYou are a CIA Agent who is tasked with making Kim Jong Un 'disappear'.");
    System.out.println("A stealth plane takes you to Kim Jong Un's mansion in the middle of the night.");
    System.out.println("You parachute out of the plane and head to a window on the East side of the house.");
    System.out.println("You're afraid. You have to decide: do you want to continue this mission? Type 'yes' or 'no'.");

    //Decision
    while(true){
      String inp = input.nextLine();
      if(inp.equals("yes")){
        System.out.println("\nYou are brave. You enter the window.");
        System.out.println("You must be careful. Guards are lurking about.\n\n");
        System.out.println("\nDirections: Enter 'n', 's', 'e', or 'w' to go north, south, east, or west respectively.");
        break;
      }
      else if(inp.equals("no")){
        System.out.println("\nYou radio your commanding officer to tell her that you can no longer complete the mission.");
        System.out.println("What you don't realize is that the CIA implants a remote bomb inside the heads of secret agents like you.");
        System.out.println("The CIA doesn't take kindly to your unpatriotism and activates the chip bomb.");
        System.out.println("YOU'RE DEAD.");
        System.exit(0);
      }
      else{
        System.out.println("Invalid Input. Try Again.");
        continue;
      }
    }

    //Starting Location
    int y = 1;
    int x = 3;

    //Game Algorithm
    while(true){
      //Declaration Boolean
      boolean goNorth = false;
      boolean goSouth = false;
      boolean goEast = false;
      boolean goWest = false;

      //Entrance Into Lobby
      int Chance = rand.nextInt(3);
      if (y == 2 && x == 2 && Chance == 2){
        System.out.println("\nThe guards saw you lurking around and fired at you.\nYOU'RE DEAD.");
        System.exit(0);
      }
      else if (y == 2 && x ==2){
        System.out.println("\nYou managed to slip past some guards that were guarding the lobby...\nBest not to come back here.");
      }

      //Entrance Into Guard Room
      if(y == 0){
        System.out.println("\nYou enter a room filled with all types of weapon: guns, knives, bombs, etc.");
        System.out.println("You realized that this was the guards' room just as a whole group of guards entered the room.");
        System.out.println("You managed to kill a few guards with your gun before they quickly overpowered you.\nYOU'RE DEAD.");
        System.exit(0);
      }

      //Entrnace Into Kim's Room
      if(y == 3 && x == 2 && Chance == 1){
        System.out.println("\nYou found Kim's room and see his fat body sleeping on the bed with no guards.");
        System.out.printf("You decide to kill him by %s him.\n", Death[rand.nextInt(4)]);
        System.out.println("You Win!");
        System.exit(0);
      }

      else if (y == 3 && x == 2 && Chance == 2){
        System.out.println("\nYou found Kim's room - but there's a problem");
        System.out.println("Kim is fully awake, surrounded by guards. He seems to have been expecting you.");
        System.out.println("You think about your wife and kids one last time before quickly raising your gun, shooting Kim.");
        System.out.println("The guards instantaneously drew their guns and fired back at you - but not before you got your shot off.");
        System.out.println("You may be dead and left your wife and kids alone, but you died as a hero.");
        System.exit(0);
      }

      else if (y == 3 && x == 2 && Chance == 0){
        System.out.println("\nYou found Kim's room - but there's a problem.");
        System.out.println("Kim is not there, but you see someone on the bed tied up.");
        System.out.println("You take the tape off of his mouth and you see Nick Burgly - a former CIA Agent that you thought was dead.\nNick disappeared in a prior mission to assassinate Kim Jong Un.");
        System.out.println("Nick worriedly told you to run away as fast as you can.");
        System.out.println("The next thing you know, you feel a blunt object hit you in the back of your head.\nGAME OVER.");
        System.exit(0);
      }


      System.out.printf("\nYou are at what appears to be a %s.\n", Rooms[y][x]);
      System.out.printf("You must choose a path. You can go:");

      try{ 
        if(getType(Rooms[y-1][x]).equals("String")){
          goNorth = true;
          System.out.printf(" *North");
        }
      }catch(Exception e){}

      try{
          if(getType(Rooms[y+1][x]).equals("String")){
          goSouth = true;
          System.out.printf(" *South");
        }
      }catch(Exception e){}

      try{
        if(getType(Rooms[y][x-1]).equals("String")){
          goWest = true;
          System.out.printf(" *West");
        }
      }catch(Exception e){}

      try{
        if(getType(Rooms[y][x+1]).equals("String")){
          goEast = true;
          System.out.printf(" *East");
          }
        }catch(Exception e){}


      System.out.println();

      //Movement Decision
      while (true){
        String Decision = input.nextLine();
        Decision = Decision.toLowerCase();
        
        if(Decision.equals("n") && goNorth == true){
          System.out.println("You go North.");
          y = y - 1;
        }
        else if(Decision.equals("s") && goSouth == true){
          System.out.println("You go South.");
          y = y + 1;
        }
        else if(Decision.equals("e") && goEast == true){
          System.out.println("You go East.");
          x = x + 1;
        }
        else if(Decision.equals("w") && goWest == true){
          System.out.println("You go West.");
          x = x - 1;
        }
        else{
          System.out.println("Invalid Direction. Try Again.");
        }
        System.out.println();
        System.out.println("------------------------------");
        break;
      }
    }
  }

  public static String getType(String Data){
    if (Data == null){
      return "Invalid Argument";
    }
    return "String";
  }
}