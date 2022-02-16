import java.util.Scanner;
import java.util.Random;

class PetGame{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    VirtualPet pet = new VirtualPet();

    int RandGender = random.nextInt(2);
    if(RandGender == 0){pet.gender = "male";}
    else{pet.gender="female";}

    int RandSpecies = random.nextInt(5);
    String Species[] = {"Dragon", "Unicorn", "Griffin", "Chupacabra", "Phoenix"};
    pet.species = Species[RandSpecies];

    System.out.println();
    System.out.printf("You found a newborn %s %s that has been abandoned by\n its mother. You decide to adopt and raise it. What will you\n name this creature?\n",pet.gender, pet.species);
    pet.name = input.nextLine();
    System.out.printf("\n%ss grow at an accelerated rate. They become full-fledged\n adults in less than a month. As they grow, their maintenance\n level is increased. Are you ready to take this responsibility?\nType yes or no: ",pet.species);
    
    while(true){
      String YesOrNo = input.nextLine();
      if(YesOrNo.equals("yes")){
        System.out.println();
        break;
      }
      else{
        System.out.println("\nWell, good/bad news! The creature is now attached to you\n anyways. There's no running from responsibilities now!\n");
        break;
      }
    }

    pet.age = 0;
    pet.hungerLevel = 0;
    pet.boredomLevel = 0;
    pet.cleanLevel = 0;

    while(true){
      pet.age = pet.age + 1;
      pet.hungerLevel = (pet.hungerLevel + pet.age);
      pet.boredomLevel = (pet.boredomLevel + pet.age);
      pet.cleanLevel = (pet.cleanLevel + pet.age);

      System.out.printf("^^^^^^^^DAY %s^^^^^^^^\n",pet.age);
      System.out.printf("%s is now %s days old.\n", pet.name, pet.age);
      VirtualPet.hungerLevel();
      System.out.println();
      VirtualPet.boredomLevel();
      System.out.println();
      VirtualPet.cleanLevel();
      System.out.println();
      System.out.println();
      System.out.printf("What would you like to do with %s?\n",pet.name);
      System.out.println("1. Feed");
      System.out.println("2. Play");
      System.out.println("3. Clean");

      while (true){
        int Decision = input.nextInt();
        if(Decision == 1){
          pet.hungerLevel = pet.hungerLevel - 15;
          System.out.printf("You fed %s\n", pet.name);
          break;
          }
        else if(Decision == 2){
          pet.boredomLevel = pet.boredomLevel - 15;
          System.out.printf("You played with %s\n", pet.name);
          break;
          }
        else if(Decision == 3){
          pet.cleanLevel = pet.cleanLevel - 15;
          System.out.printf("You Cleaned %s\n", pet.name);
          break;
        }
        else{
          System.out.println("Invalid Input. Try Again");
          continue;
        }
      }

      System.out.println();
      
      if(pet.hungerLevel > pet.RUNAWAY_STAT_THRESHOLD && pet.boredomLevel > pet.RUNAWAY_STAT_THRESHOLD && pet.cleanLevel > pet.RUNAWAY_STAT_THRESHOLD){
        System.out.printf("%s is sick of your negligence. \n%s became too dirty, too bored, and too hungry.\nIt ran away to find someone better to take care of it. \n\n", pet.name, pet.name);
        break;
      }
    }
  System.out.printf("You took care of %s for a total of: %s days\n",pet.name,pet.age);

  if (pet.age < 10){
    System.out.println("You're a horrible person. You owning a pet is a sin against humanity.");
  }
  else if (pet.age < 25){
    System.out.println("Please, for the sake of animals, don't ever own another pet again.");
  }
  else{
    System.out.println("Good Try. Do better next time.");
    }
  }
}