import java.util.Scanner;

public class RSAPublicKey{

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();

    for(int i = 0; i<t; i++){
      int p = input.nextInt();
      int q = input.nextInt();
      int e = input.nextInt();
      input.nextLine();

      int n = p * q;
      int totient = (p-1) * (q-1);

      if(PrimeNum(q) == true && PrimeNum(p) == true && e < totient){
        long key = ((long)p * q);
        System.out.printf("RSA Public Key: n=%s e=%s\n",key,e);
      }
      else if(e > totient){System.out.println("Invalid e for RSA Key!");}
      else{System.out.println("Invalid n for RSA Key!");}
    }
  }

  static boolean PrimeNum(int Number) {

      int DivisibleAmount = 0;
      int IncrementValue = Number;

      while(IncrementValue != 0){
        if(Number % IncrementValue == 0){
          DivisibleAmount += 1;
        }
        IncrementValue -= 1;
      }
        DivisibleAmount -= 2;      
        if(DivisibleAmount == 0){return true;}
        else{return false;}
  }
}