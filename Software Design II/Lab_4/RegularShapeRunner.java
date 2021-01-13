import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class RegularShapeRunner{

	public static void main(String[] args) {
		

		RegularShape triangle = new Triangle(5);
		RegularShape square = new Square(5);

		ArrayList<RegularShape> shapes = new ArrayList<RegularShape>();
		shapes.add(triangle); shapes.add(square);
		
		//Display the properties of all test shapes.
		for (RegularShape testRegularShape : shapes) {
			System.out.println(testRegularShape.getAngles());
			System.out.println(testRegularShape.getArea());
		}
		
		/*#TODO*/
		//Create a RegularShapeMonitor objRegular
		RegularShapeMonitor shapeMonitor = new RegularShapeMonitor();
		
		//add it to all shape objects (triangle and square)
		for (RegularShape testRegularShape : shapes){
			testRegularShape.addObserver(shapeMonitor);
		}
		
		
		triangle.setEdgeLength(0);
		square.setEdgeLength(10);
	}

}
