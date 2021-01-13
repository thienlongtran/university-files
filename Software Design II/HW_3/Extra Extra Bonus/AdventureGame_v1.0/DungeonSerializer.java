import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*This serialization program uses the Serializer program from Lab 5;
CartoonCharacter Serialization & Deserialization, as a template.*/

public class DungeonSerializer {
	
	private static ObjectOutputStream outputDungeon;
	private static ObjectInputStream inputDungeon;
	private static PrintWriter writer;
	
	public static void serializeDungeon(Dungeon savedDungeon) {
		try{
            String outputFileName;
            while(true){
                System.out.printf("Enter name of your save-file ending with .dat: ");
                Scanner outputFile = new Scanner(System.in);
                while(!outputFile.hasNext()){
                    //wait for user to enter something
                }
                outputFileName = outputFile.nextLine();

                if(outputFileName.endsWith(".dat")){
                    outputFile.close();
                    break;
                }
                else{
                    System.out.println("File extension must end with .dat");
                    //Repeat process
                }
        }

			outputDungeon = new ObjectOutputStream(new FileOutputStream(outputFileName));
			outputDungeon.writeObject(savedDungeon);
            outputDungeon.close();}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static Dungeon deserializeDungeon() {
		Dungeon loadedDungeon = null;

		//Continues repeating if file not found
		while(true){
			Scanner inputFile = new Scanner(System.in);
			System.out.printf("Enter the name of the saved game including .dat: ");
			while(!inputFile.hasNext()){
				//wait for user to enter something
			}
			String inputFileName = inputFile.nextLine();
			
			try{
				inputDungeon = new ObjectInputStream(new FileInputStream(inputFileName));
				loadedDungeon = (Dungeon)inputDungeon.readObject();
				break;
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e){
				System.out.println("File not found. Check spelling and try again.");
				continue;
			}
		}
		return loadedDungeon;
	}
	
	public static void printToFile(String stringToFile) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter("DungeonAnalysis.txt");
		writer.print(stringToFile);
		writer.printf("Testing printToFile: This dungeon is pretty cool!");
		writer.close();
	}

}
