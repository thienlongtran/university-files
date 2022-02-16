import java.util.Scanner;

class Fibonacci{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int TestCases = input.nextInt();

    for(int i = 0; i<TestCases; i++){
      int FinalNum = 1;
      int Fib = input.nextInt();
      int numA = 1;
      int numB;

      if(Fib == 0){
        System.out.println("0");
        continue;
      }

      for(int x = 0; x<Fib; x++){
        numA = numA + numA;
        System.out.println(numA);
      }
      System.out.println(FinalNum);
    }
  }
}