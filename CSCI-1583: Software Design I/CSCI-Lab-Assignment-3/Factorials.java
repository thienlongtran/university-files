import java.util.Scanner;

public class Factorials{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int TestCases = input.nextInt();

    for(int i = 0; i<TestCases; i++){
      long FinalNum = 1;
      int Factorial = input.nextInt();
      if(Factorial == 0){
        System.out.println("1");
        continue;
      }

      while(true){
        if(Factorial == 1){
          System.out.println(FinalNum);
          break;
        }

        FinalNum = FinalNum * Factorial;
        Factorial -= 1;
      }
    }
  }
}