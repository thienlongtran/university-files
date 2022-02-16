import java.util.Scanner;

class DraughtingDollars {
  public static void main(String[] args) {
   //Data Model: Keg Ratio, Price, Keg Gallons, Pint in Ounces, Price by Keg
   double kegInGallons = 15.5;
   int gallonInOunces = 128;
   int pintInOunces = 16;
   double KegRatio;    // Input 1
   double priceOfPint; // Input 2
   double priceOfKeg;  // Answer

   //Take Two Inputs: Keg Left in Percentage and Price Per Pint
   Scanner input = new Scanner(System.in);
   KegRatio = input.nextDouble();
   priceOfPint = input.nextDouble();

   //Determine Pints Left in Keg --- Ans = Beer Left in oz / Pint in oz
  double KegInOunces = (KegRatio * kegInGallons) * gallonInOunces;
  double KegPints = KegInOunces / pintInOunces;

   //Determine Price --- Ans = Price per Pint * Pints of Beer
  priceOfKeg = KegPints * priceOfPint;

   //Print Ans

  System.out.printf("There is $%.2f of beer left in keg\n", priceOfKeg);

  }
}