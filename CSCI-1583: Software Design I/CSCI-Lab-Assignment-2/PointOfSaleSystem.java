import java.util.Scanner;

class Main{
  public static void main(String[] args){

    double S1 = 1.50;
    double S2 = 1.75;
    double S3 = 2.50;
    double S4 = 2.75;
    double S5 = 0.99;
    double S6 = 1.25;
    double SalesTax = 0.065;

    Scanner input = new Scanner(System.in);
    int TestCases = input.nextInt();
    input.nextLine();

    for(int i = 0; i != TestCases; i++){
      String sequence = input.nextLine();
      Scanner reader = new Scanner(sequence);
      reader.useDelimiter(" ");

      double Price = 0;
      double FinalValue = 0;

      while (reader.hasNextInt() == true){

      switch(reader.nextInt()){
        case 1: FinalValue += S1;
                break;
        case 2: FinalValue += S2;
                break;
        case 3: FinalValue += S3;
                break;
        case 4: FinalValue += S4;
                break;
        case 5: FinalValue += S5;
                break;
        case 6: FinalValue += S6;
                  break;
      }}
      FinalValue = (FinalValue*SalesTax) + FinalValue;
      System.out.printf("Please pay $%.2f\n", FinalValue);
      System.out.println("Thank you for eating at McDowell’s!");
    }
  }
}