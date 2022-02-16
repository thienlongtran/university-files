/**
*@author Thien
*@version 1.0
*/

public class Circle{
  private double diameter;
  private double circ;
  private double area;
  private double radius;

  /**
  *This creates a circle object.
  *@param radius This is the radius of the circle.
  */

  public Circle(double radius){
    this.radius = radius;
  }

  /**
  *This allows us to set the circ of the circle
  *@param circ The circumference of the circle
  */
  public void setCirc(double circ){
    this.circ = circ;
  }

  /**
  *This is how to get the circumference of our circle.
  *@return circ The circumference of our circle.
  */
  public double getCirc(){
    return this.circ;
  }
}