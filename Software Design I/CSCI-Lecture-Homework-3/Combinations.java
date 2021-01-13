public class Combinations{
  public static double FindAns(int x){
      double Result = 1;
      double Numming = x;

      while(true){
        if(Numming == 1.0){break;}
        Result = Numming * Result;
        Numming = Numming - 1;
      }
      return Result;
  }
}
