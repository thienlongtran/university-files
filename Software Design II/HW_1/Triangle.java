/**
   @author Thien Tran
   @version 1.2
   
 */

public class Triangle extends Shape{

  /**
  *Initalizes a new Triangle object
  *@param one One vertex of the triangle
  *@param two One vertex of the triangle
  *@param three One vertex of the triangle
  */
  public Triangle(Point2D one, Point2D two, Point2D three){

    points = new Point2D[3];

    points[0] = one;
    points[1] = two;
    points[2] = three;
  }
  
  /**
  This calculates the perimeter of the Triangle.
  @return totalDistance the distance of all of the sides added up.
  */
  public double getPerimeter(){
    double Distance1 = points[0].distance(points[1]);
    double Distance2 = points[0].distance(points[2]);
    double Distance3 = points[1].distance(points[2]);
    double totalDistance = Distance1 + Distance2 + Distance3;
    return(totalDistance);
  }

  /**
  This calculates the area of the Triangle.
  @return totalArea the area of the Triangle.
  */
  public double getArea(){
    Point2D[] DifferentY = new Point2D[1];
    Point2D[] SameY = new Point2D[2];

    if(points[0].getY() == points[1].getY()){
      DifferentY[0] = points[2];
      SameY[0] = points[0];
      SameY[1] = points[1];
    }

    else if(points[0].getY() == points[2].getY()){
      DifferentY[0] = points[1];
      SameY[0] = points[0];
      SameY[1] = points[2];
    }

    else{
      DifferentY[0] = points[0];
      SameY[0] = points[1];
      SameY[1] = points[2];
    }

    double height = Math.abs(DifferentY[0].getY() - SameY[0].getY());
    double base = Math.abs(SameY[1].getX() - SameY[0].getX());
    double totalArea = 0.5 * base * height;
    return (totalArea);
  }
}
