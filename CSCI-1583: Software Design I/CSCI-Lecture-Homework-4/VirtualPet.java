public class VirtualPet{
  //Attributes
  static String name;
  static String gender;
  static String species;
  static int age;
  static int hungerLevel;
  static int cleanLevel;
  static int boredomLevel;

  //THRESHOLDS
  static int LOW_STAT_THRESHOLD = 25;
  static int MEDIUM_STAT_THRESHOLD = 50;
  static int HIGH_STAT_THRESHOLD = 75;
  static int HORRIBLE_STAT_THRESHOLD = 100;
  static int RUNAWAY_STAT_THRESHOLD = 120;

  public static void hungerLevel(){
    if(hungerLevel > HORRIBLE_STAT_THRESHOLD){
      System.out.printf("Hunger Level: Starving To Death");
    }
    else if(hungerLevel > HIGH_STAT_THRESHOLD){
      System.out.printf("Hunger Level: Extremely Hungry");
    }
    else if(hungerLevel > MEDIUM_STAT_THRESHOLD){
      System.out.printf("Hunger Level: Very Hungry");
    }
    else if(hungerLevel > LOW_STAT_THRESHOLD){
      System.out.printf("Hunger Level: Hungry");
    }
    else{System.out.printf("Hunger Level: Well Fed");}
  }

  public static void boredomLevel(){
    if(boredomLevel > HORRIBLE_STAT_THRESHOLD){
      System.out.printf("Boredom Level: Bored To Death");
    }
    else if(boredomLevel > HIGH_STAT_THRESHOLD){
      System.out.printf("Boredom Level: Extremely Bored");
    }
    else if(boredomLevel > MEDIUM_STAT_THRESHOLD){
      System.out.printf("Boredom Level: Very Bored");
    }
    else if(boredomLevel > LOW_STAT_THRESHOLD){
      System.out.printf("Boredom Level: Bored");
    }
    else{System.out.printf("Boredom Level: Entertained");}
  }

  public static void cleanLevel(){
    if(cleanLevel > HORRIBLE_STAT_THRESHOLD){
      System.out.printf("Clean Level: Biohazard");
    }
    else if(cleanLevel > HIGH_STAT_THRESHOLD){
      System.out.printf("Clean Level: Extremely Dirty");
    }
    else if(cleanLevel > MEDIUM_STAT_THRESHOLD){
      System.out.printf("Clean Level: Very Dirty");
    }
    else if(cleanLevel > LOW_STAT_THRESHOLD){
      System.out.printf("Clean Level: Dirty");
    }
    else{System.out.printf("Clean Level: Clean");}
  }
}