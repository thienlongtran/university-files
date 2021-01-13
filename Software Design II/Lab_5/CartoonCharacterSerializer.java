import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

public class CartoonCharacterSerializer {
	
	private static ObjectOutputStream outputCartoon;
	private static ObjectInputStream inputCartoon;
	private static PrintWriter writer;
	
	//Method that writes one CartoonCharacter object out to a file
	public static void serializeCharacter(CartoonCharacter character) {
		try{
			outputCartoon = new ObjectOutputStream(new FileOutputStream("Cartoon.ser"));
			outputCartoon.writeObject(character);
			outputCartoon.close();}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static CartoonCharacter deserializeCharacter() {
		CartoonCharacter cartoon = null;
		
		try{
			inputCartoon = new ObjectInputStream(new FileInputStream("Cartoon.ser"));
			cartoon = (CartoonCharacter)inputCartoon.readObject();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return cartoon;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter("C-137.txt");
		writer.print(stringToFile);
		writer.printf("PrintWriter makes printing %d times easier!%n",50);
		writer.close();
	}

}
