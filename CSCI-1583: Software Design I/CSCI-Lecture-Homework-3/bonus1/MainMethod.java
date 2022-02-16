class MainMethod{ 
  public static void main(String[] args){
    int Num1 = 100;
    int Num2 = 5;
    
    double TopOfComb = Combinations.FindAns(Num1); //uwu
    double BottomOfComb = Combinations.FindAns(Num2) * Combinations.FindAns((Num1-Num2));
    int FinalAns = (int)(TopOfComb/BottomOfComb);

    System.out.printf("There are: %s possible combinations of a group of %s people when there is a total of %s people present.", FinalAns, Num2, Num1);
  }
}
