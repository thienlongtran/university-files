import java.util.Scanner;

public class RockPaperScissors{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int TestCases = 0;
    TestCases = input.nextInt();
    input.nextLine();

    for (int i=0; i<TestCases; i++){
      String sequence = input.nextLine();
      Scanner reader = new Scanner(sequence);
      reader.useDelimiter(" ");

      String Player1 = reader.next();
      String Player2 = reader.next();

      if (Player1.equals(Player2)){
        System.out.println("Tie!");
      }
      else if (Player1.equals("paper") && Player2.equals("scissors")){
        System.out.println("Player 2 wins!");
      }
      else if (Player1.equals("paper") && Player2.equals("rock")){
        System.out.println("Player 1 wins!");
      }
      else if (Player1.equals("scissors") && Player2.equals("rock")){
        System.out.println("Player 2 wins!");
      }
      else if (Player1.equals("scissors") && Player2.equals("paper")){
        System.out.println("Player 1 wins!");
      }
      else if (Player1.equals("rock") && Player2.equals("paper")){
        System.out.println("Player 2 wins!");
      }
      else if (Player1.equals("rock") && Player2.equals("scissors")){
        System.out.println("Player 1 wins!");
      }
      else{
        System.out.println("Im an idiot programmer and deserve to be an art major.");
      }
    }
  }
}