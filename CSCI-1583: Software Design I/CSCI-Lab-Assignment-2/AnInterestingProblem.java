import java.util.Scanner;

public class AnInterestingProblem{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int t = input.nextInt();
    input.nextLine();

    for(int i = 0; i != t; i++){
      String sequence = input.nextLine();
      Scanner reader = new Scanner(sequence);
      reader.useDelimiter(" ");
      
      int AmountOfYears = 0;

      double DepositAmount = reader.nextDouble();
      double InterestRate = reader.nextDouble();
      double MoneyAmount = DepositAmount;

      while (MoneyAmount < 1000000){
        AmountOfYears += 1;
        MoneyAmount += (MoneyAmount * ((double)InterestRate/100));
      }

      System.out.printf("%s years\n",AmountOfYears);

    }
  }
}