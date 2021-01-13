/**
   @author Thien Tran
   @version 1.1
   
 */
   
public class Rectangle extends Shape{

  private Point2D[] pointDifferentX = new Point2D[2];
  private Point2D[] pointSameX = new Point2D[2];
  private Point2D[] pointDifferentY = new Point2D[2];
  private Point2D[] pointSameY = new Point2D[2];
  private int end;

  /**
  *Initalizes a new Rectangle object
  *@param one One vertex of the rectangle
  *@param two One vertex of the rectangle
  *@param three One vertex of the rectangle
  *@param four One vertex of the rectangle
  */
  public Rectangle(Point2D one, Point2D two, Point2D three, Point2D four){
    points = new Point2D[4];
    points[0] = one;
    points[1] = two;
    points[2] = three;
    points[3] = four;
    end = points.length;

    pointSameX[0] = points[0];
    int SameX = 1;
    int DifferentX = 0;

    for(int i = 1; i < end; i++){

      if(points[i].getX() == points[0].getX()){
        pointSameX[SameX] = points[i];
      }

      else{
        pointDifferentX[DifferentX] = points[i];
        DifferentX =+ 1;
      }
    }

    pointSameY[0] = points[0];
    int SameY = 1;
    int DifferentY = 0;

    for(int i = 1; i < end; i++){

      if(points[i].getY() == points[0].getY()){
        pointSameY[SameY] = points[i];
      }

      else{
        pointDifferentY[DifferentY] = points[i];
        DifferentY =+ 1;
      }
    }
  }
 
  /**
  This calculates the perimeter of the Rectangle.
  @return totalDistance the distance of all of the sides added up.
  */ 
  public double getPerimeter(){
    double Distance1 = pointSameX[0].distance(pointSameX[1]);
    double Distance2 = pointSameY[0].distance(pointSameY[1]);
    double totalDistance = (Distance1 + Distance2) * 2;
    return(totalDistance);
  }

  /**
  This calculates the area of the Rectangle.
  @return totalArea the area of the Rectangle.
  */
  public double getArea(){
    double Distance1 = pointSameX[0].distance(pointSameX[1]);
    double Distance2 = pointSameY[0].distance(pointSameY[1]);
    double totalArea = (Distance1 * Distance2);
    return(totalArea);
  }
}