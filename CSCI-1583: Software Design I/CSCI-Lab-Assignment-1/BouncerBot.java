import java.util.Scanner;

class BouncerBot{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int TodayDay = input.nextInt();
    int TodayMonth = input.nextInt();
    int TodayYear = input.nextInt();
    int BirthDay = input.nextInt();
    int BirthMonth = input.nextInt();
    int BirthYear = input.nextInt();

    if (TodayDay == BirthDay && TodayMonth == BirthMonth && TodayYear-BirthYear >= 21){
      System.out.println(true);
    }
    else{System.out.println(false);}
  }
}