import java.util.Scanner;

class PapersPlease{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    boolean Passport = input.nextBoolean();
    boolean License = input.nextBoolean();
    boolean BirthC = input.nextBoolean();

    if(Passport == true){
      System.out.println("true");
    }
    else if(License == true && BirthC == true){
      System.out.println("true");
    }
    else{
      System.out.println("false");
    }
  }
}