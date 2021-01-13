public class Geometry{
  public static double AreaRectangle(double width, double length){
    return width*length;
  }
  public static double AreaCircle(double radius){
    double CircleArea = Math.PI * (Math.pow(radius, 2.0));
    return CircleArea;
  }
  public static double AreaTriangle(double base, double height){
    return base * height * 0.5;
  }
  public static double PerimeterRectangle(double width, double length){
    return 2.0 * (length + width);
  }
  public static double PerimeterCircle(double radius){
    return (2 * Math.PI * radius);
  }
  public static double PerimeterTriangle(double s1, double s2, double s3){
    return s1+s2+s3;
  }
}