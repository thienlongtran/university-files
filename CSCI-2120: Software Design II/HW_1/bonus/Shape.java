/**
   @author Thien Tran
   @version 1.0
   
 */
   
public abstract class Shape{
  public abstract double getArea();
  public abstract double getPerimeter();
  public Point2D[] points;

  public Point2D getVertex(int index){
    return points[index];
  }
}