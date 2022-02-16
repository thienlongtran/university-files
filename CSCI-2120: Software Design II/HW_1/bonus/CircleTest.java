/**
   @author Thien Tran
   @version 1.0
   
 */

import org.junit.*;
import static org.junit.Assert.*;

public class CircleTest{
  private double resultArea;
  private double resultPerimeter;

  @Before
  public void setUp(){
    resultArea = 0;
    resultPerimeter = 0;
  }

  @Test
  public void testCircle(){
    Point2D origin = new Point2D(0,0);
    Circle targetCircle = new Circle(origin, 5);

    System.out.println("");
    System.out.println("Testing Circle Functions");

    resultArea = targetCircle.getArea();
    assertTrue((int)(resultArea*1000) == 78539);
    System.out.printf("Result getArea: %.2f\n", (resultArea));


    resultPerimeter = targetCircle.getPerimeter();
    assertTrue((int)(resultPerimeter * 1000) == 31415);
    System.out.printf("Result getPerimeter: %.2f\n", (resultPerimeter));
  }
}