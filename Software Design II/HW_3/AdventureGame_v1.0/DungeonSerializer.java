import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

/*This serialization program uses the Serializer program from Lab 5;
CartoonCharacter Serialization & Deserialization, as a template.*/

public class DungeonSerializer {
	
	private static ObjectOutputStream outputDungeon;
	private static ObjectInputStream inputDungeon;
	private static PrintWriter writer;
	
	public static void serializeDungeon(Dungeon savedDungeon) {
		try{
			outputDungeon = new ObjectOutputStream(new FileOutputStream("SavedDungeon.dat"));
			outputDungeon.writeObject(savedDungeon);
			outputDungeon.close();}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static Dungeon deserializeDungeon() {
		Dungeon savedDungeon = null;
		
		try{
			inputDungeon = new ObjectInputStream(new FileInputStream("SavedDungeon.dat"));
			savedDungeon = (Dungeon)inputDungeon.readObject();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return savedDungeon;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter("DungeonAnalysis.txt");
		writer.print(stringToFile);
		writer.println("Testing printToFile: This dungeon game is cool!");
		writer.close();
	}

}
