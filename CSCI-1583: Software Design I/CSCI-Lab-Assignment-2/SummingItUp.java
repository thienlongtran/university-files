import java.util.Scanner;

class SummingItUp{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int TestCases = input.nextInt();

    while (TestCases != 0){
    int FinalValue = 0;
    int num1 = input.nextInt();
    int num2 = input.nextInt();
    int LargerNum = Math.max(num1,num2);
    int SmallerNum = Math.min(num1,num2);

    while (LargerNum != SmallerNum){
      FinalValue += LargerNum;
      LargerNum -= 1;
    }
    FinalValue += SmallerNum;
    System.out.printf("%s\n",FinalValue);
    TestCases -= 1;
    }
  }
}
