//(a*x)%m == 1
//a and m given by input 1 and 2

import java.util.Scanner;

public class RSAPrivateKey{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int TestCases = input.nextInt();

    for(int i = 0; i<TestCases; i++){
      long x = 0;
      int a = input.nextInt();
      int m = input.nextInt();
      
      while(true){
      if((a*x)%m == 1){
        System.out.println(x);
        break;
      }
      else{
        x += 1;
      }
      }
    }
  }
}