/**
   @author Thien Tran
   @version 1.1
   
 */

import org.junit.*;
import static org.junit.Assert.*;

public class ShapeTests{
  private double resultArea;
  private double resultPerimeter;
  private String resultVertex;

  @Before
  public void setUp(){
    resultArea = 0;
    resultPerimeter = 0;
    resultVertex = "";
  }

  @Test
  public void testRectangle(){
  /**
  *Initalizes a new Rectangle object
  *@param pointOne One vertex of the rectangle (x,y)
  *@param pointTwo One vertex of the rectangle (x,y)
  *@param pointThree One vertex of the rectangle (x,y)
  *@param pointFour One vertex of the rectangle (x,y)
  */
  Point2D pointOne = new Point2D(0,0);
  Point2D pointTwo = new Point2D(0,5);
  Point2D pointThree = new Point2D(4,0);
  Point2D pointFour = new Point2D(4,5);

  Rectangle targetRectangle = new Rectangle(pointOne, pointTwo, pointThree, pointFour);
  
  System.out.println("");
  System.out.println("Testing Rectangle Functions");
  resultArea = targetRectangle.getArea();
  assertTrue(resultArea == 20);

  resultPerimeter = targetRectangle.getPerimeter();
  assertTrue(resultPerimeter == 18);
  
  resultVertex = targetRectangle.getVertex(1).toString();
  assertTrue(resultVertex.equals("x: 0.0 y: 5.0"));

  System.out.printf("Result getVertex: %s\n", resultVertex);
  System.out.printf("Result getArea: %.2f\n", resultArea);
  System.out.printf("Result getPerimeter: %.2f\n", resultPerimeter);
  }


  @Test
  public void testTriangle(){
  /**
  *Initalizes and tests a new Triangle object
  *@param pointOne One vertex of the triangle (x,y)
  *@param pointTwo One vertex of the triangle (x,y)
  *@param pointThree One vertex of the triangle (x,y)
  */
  Point2D pointOne = new Point2D(0,0);
  Point2D pointTwo = new Point2D(5,0);
  Point2D pointThree = new Point2D(3,5);

  Triangle targetTriangle = new Triangle(pointOne, pointTwo, pointThree);

  System.out.println("");
  System.out.println("Testing Triangle Functions");
  resultArea = targetTriangle.getArea();
  assertTrue(resultArea == 12.5);

  resultPerimeter = targetTriangle.getPerimeter();
  assertTrue((int)(resultPerimeter*1000) == 16216);

  resultVertex = targetTriangle.getVertex(1).toString();
  assertTrue(resultVertex.equals("x: 5.0 y: 0.0"));

  System.out.printf("Result getVertex: %s\n", resultVertex);
  System.out.printf("Result getArea: %.2f\n", resultArea);
  System.out.printf("Result getPerimeter: %.2f\n", resultPerimeter);
  }
}
