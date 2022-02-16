import java.util.Scanner;

public class PrimeNumber{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int TestCases = input.nextInt();
    input.nextLine();

    for(int i = 0; i<TestCases; i++){
      int DivisibleAmount = 0;
      int Number = input.nextInt();
      int IncrementValue = Number;
      input.nextLine();

      while(IncrementValue != 0){
        if(Number % IncrementValue == 0){
          DivisibleAmount += 1;
        }
        IncrementValue -= 1;
      }
        DivisibleAmount -= 2;      
        if(DivisibleAmount == 0){System.out.println(true);}
        else{System.out.println(false);}
    }
  }
}