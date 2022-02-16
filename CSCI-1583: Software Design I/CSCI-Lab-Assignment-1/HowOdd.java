import java.util.Scanner;

class HowOdd{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int Variable = input.nextInt();

    if (Variable%2 == 0){
      System.out.println(false);
    }
    else{
      System.out.println(true);
    }
  }
}