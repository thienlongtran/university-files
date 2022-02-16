import java.util.Scanner;

public class SimpleCalculator{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int TestCases = input.nextInt();
    input.nextLine();

    for(int i = 0; i<TestCases; i++){
      String sequence = input.nextLine();
      Scanner inp = new Scanner(sequence);

      int num1 = inp.nextInt();
      String operator = inp.next();
      int num2 = inp.nextInt();

      if(operator.equals("+")){System.out.println(num1+num2);}
      else if(operator.equals("-")){
        System.out.println(num1-num2);}
      else if(operator.equals("/")){
        System.out.println(num1/num2);}
      else if(operator.equals("*")){
        System.out.println(num1*num2);}
      else if(operator.equals("**")){
        int ExponentValue = num1;
	if(num2 == 0){ExponentValue = ExponentValue = 1;
		      System.out.println(ExponentValue);
                      continue;}
        for(int x = 1; x != num2; x++){
          ExponentValue *= num1;
        }
        System.out.println(ExponentValue);}
      else if(operator.equals("%")){
        System.out.println(num1%num2);}
      else{System.out.println("Im an idiot programmer");}

    }
  }
}