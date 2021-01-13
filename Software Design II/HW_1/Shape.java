/**
   @author Thien Tran
   @version 1.0
   
 */
   
public abstract class Shape{
	/**
	*getArea method to be implemented in subclasses
	*/
  public abstract double getArea();

 	/**
	*getPerimeter method to be implemented in subclasses
	*/
  public abstract double getPerimeter();
  public Point2D[] points;

  	/**
  	*Returns a Point2D object from an array of a shape's points
  	*@param index the position in an array (starting at 0)
  	*/
  public Point2D getVertex(int index){
    return points[index];
  }
}