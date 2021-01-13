public class Time{
  public static double secondsToMinutes(int seconds){
    return (seconds/60.0);
  }
  public static double secondsToHours(int seconds){
    return (seconds/3600.0);
  }
  public static double secondsToDays(int seconds){
    return (seconds/3600.0/24);
  }
  public static double secondsToYears(int seconds){
    return (seconds/3600.0/24.0/365.0);
  }
  public static double minutesToSeconds(double minutes){
    return (minutes * 60.0);
  }
  public static double hoursToSeconds(double hours){
    return (hours * 3600.0);
  }
  public static double daysToSeconds(double days){
    return (days * 3600.0 * 24.0 );
  }
  public static double yearsToSeconds(double years){
    return (years * 3600.0 * 24.0 * 365.0);
  }
}