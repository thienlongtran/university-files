/**
   @author Thien Tran
   @version 1.0
   
 */
   
public class Circle extends Shape{
  private double radius;

  public Circle(Point2D origin, double radius){
    points = new Point2D[1];
    points[0] = origin;
    this.radius = radius;
  }
  
  public double getPerimeter(){
    return Math.PI*(2*radius);
  }

  public double getArea(){
    return Math.PI*(radius * radius);
  }
}