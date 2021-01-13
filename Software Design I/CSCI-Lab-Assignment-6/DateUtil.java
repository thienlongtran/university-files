public class DateUtil{
  static String format(int month, int day, int year){
    return String.format("0%s/0%s/%s", month, day, year);
  }
  //Returns String of date, formatted as mm/dd/yyyy

  static String format(String date, int year){
    return String.format("%s, %s", date, year);
  }
  //Returns String of date
  static String format(String month, int day, int year){
    return String.format("%s %s, %s", month, day, year);
  }
  //Returns String of date, formatted as month dd yyyy
  static String format(String month, String day, String year){
    return String.format("%s %s, %s", month, day, year);
  }
  //Returns String of date, formatted as month day year
}