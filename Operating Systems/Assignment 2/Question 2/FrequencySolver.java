import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencySolver {
	
	//General Runner for Debugging Purposes
	public static void main(String[] args){
		long startTime;
		long endTime;

        System.out.println("Running One Threaded Calculation...");
		startTime = System.currentTimeMillis();
		getFrequencyOneThread("enwik9");
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - One Thread: "+(double)(endTime-startTime)/1000 + " seconds");
        System.out.println();

        System.out.println("Running Two Threaded Calculation...");
		startTime = System.currentTimeMillis();
		getFrequencyTwoThreads("enwik9");
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - Two Threads: "+(double)(endTime-startTime)/1000 + " seconds");
        System.out.println();
        
        System.out.println("Running Three Threaded Calculation...");
		startTime = System.currentTimeMillis();
		getFrequencyThreeThreads("enwik9");
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time - Three Threads: "+(double)(endTime-startTime)/1000 + " seconds");
        System.out.println();
	}

    /**
	 * Calculate word frequency with three threads.
	 */
    public static void getFrequencyThreeThreads(final String fileName){
        ExecutorService frequencyThreads = Executors.newCachedThreadPool();
        Vector<String> untrimmedLineList = new Vector<String>();
        Vector<String[]> lineList = new Vector<String[]>();
        lineList.add(new String[0]);

        AtomicBoolean readThreadIsRunning = new AtomicBoolean(false);
        AtomicBoolean trimThreadIsRunning = new AtomicBoolean(false);

        Thread readFromFile = new Thread(){
            public void run(){
                readThreadIsRunning.set(true);
                try{
                    File wikiDump = new File(fileName);
                    Scanner reader = new Scanner(wikiDump);

                    while(reader.hasNext()){
                        String newLine = reader.nextLine();
                        untrimmedLineList.add(newLine);
                    }

                    reader.close();
                    readThreadIsRunning.set(false);
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found.");
                    e.printStackTrace();
                }
            }
        };

        Thread trimAndSave = new Thread(){
            public void run(){
                trimThreadIsRunning.set(true);

                while(true){
                    if(untrimmedLineList.size() > 0 || readThreadIsRunning.get()){
                        String newLine = "";

                        if(untrimmedLineList.size() > 0){
                            newLine = untrimmedLineList.remove(0);
                        }

                        String[] lines = newLine.replaceAll("[^a-zA-Z0-9 - _]", " ").split(" ");
                        lineList.add(lines);
                    }
                    else{
                        trimThreadIsRunning.set(false);
                        break;
                    }
                }
            }
        };

        Thread countFrequencyFromVector = new Thread(){
            public void run(){
                AtomicIntegerArray frequencyTable = new AtomicIntegerArray(9);

                while(true){
                        if(lineList.size() > 0 || readThreadIsRunning.get() || trimThreadIsRunning.get()){
                            String[] lines = new String[0];

                            if(lineList.size() > 0){
                                lines = lineList.remove(0);
                            }

                            //Count Word Length
                            for(int i = 0; i < lines.length; i++){
                                int index = lines[i].length();
                                if(index <= 8){
                                    frequencyTable.getAndIncrement(index);
                                }
                                else{
                                    frequencyTable.getAndIncrement(8);
                                }
                            }
                        }

                        //If this else comes true, it means that there is no more items to read at all
                        else{
                            printFrequencyTableInfo(frequencyTable);
                            break;
                        }     
                }
            }
        };

        frequencyThreads.execute(readFromFile);
        frequencyThreads.execute(trimAndSave);
        frequencyThreads.execute(countFrequencyFromVector);
		frequencyThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!frequencyThreads.isTerminated()){
			
		}

	}

	/**
	 * Calculate word frequency with one thread.
	 */
	public static void getFrequencyOneThread(final String fileName){
        AtomicIntegerArray frequencyTable = new AtomicIntegerArray(9);
    
        Thread frequencyThread = new Thread(){
            public void run(){
                try{
                    File wikiDump = new File(fileName);
                    Scanner reader = new Scanner(wikiDump);

                    while(reader.hasNext()){
                        String newLine = reader.nextLine();
                        String[] lines = newLine.replaceAll("[^a-zA-Z0-9 - _]", " ").split(" ");

                        //Count Word Length
                        for(int i = 0; i < lines.length; i++){
                            int index = lines[i].length();

                            if(index <= 8){
                                frequencyTable.getAndIncrement(index);
                            }
                            else{
                                frequencyTable.getAndIncrement(8);
                            }
                        }
                    }

                    reader.close();
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found.");
                    e.printStackTrace();
                }
            }
        };

        ExecutorService frequencyThreads = Executors.newCachedThreadPool();

        frequencyThreads.execute(frequencyThread);

		frequencyThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!frequencyThreads.isTerminated()){
			
		}
        
        printFrequencyTableInfo(frequencyTable);

	}
	
	/**
	 * Calculate word frequency with two threads.
	 */
	public static void getFrequencyTwoThreads(final String fileName){
        ExecutorService frequencyThreads = Executors.newCachedThreadPool();
        Vector<String> lineList = new Vector<String>();
        lineList.add("");
        AtomicBoolean readThreadIsRunning = new AtomicBoolean(false);

        Thread readFromFileAndSaveStrippedString = new Thread(){
            public void run(){
                readThreadIsRunning.set(true);
                try{
                    File wikiDump = new File(fileName);
                    Scanner reader = new Scanner(wikiDump);

                    while(reader.hasNext()){
                        String newLine = reader.nextLine();
                        
                        lineList.add(newLine);
                    }

                    reader.close();
                    readThreadIsRunning.set(false);
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found.");
                    e.printStackTrace();
                }
            }
        };

        Thread countFrequencyFromVector = new Thread(){
            public void run(){
                AtomicIntegerArray frequencyTable = new AtomicIntegerArray(9);

                while(true){
                    //Run while there are items in the data structure or the read thread is running
                    //try{
                        if(lineList.size() > 0 || readThreadIsRunning.get()){
                            String[] lines = new String[0];
                            if(lineList.size() > 0){
                                lines = lineList.remove(0).replaceAll("[^a-zA-Z0-9 - _]", " ").split(" ");
                            }

                            //Count Word Length
                            for(int i = 0; i < lines.length; i++){
                                int index = lines[i].length();
                                if(index <= 8){
                                    frequencyTable.getAndIncrement(index);
                                }
                                else{
                                    frequencyTable.getAndIncrement(8);
                                }
                            }

                            //Thread.sleep(0, 1);
                        }

                        //If this else comes true, it means that there is no more items to read at all
                        else{
                            printFrequencyTableInfo(frequencyTable);
                            break;
                        }
                    //}catch(InterruptedException e){e.printStackTrace();}       
                }
            }
        };

        frequencyThreads.execute(readFromFileAndSaveStrippedString);
        frequencyThreads.execute(countFrequencyFromVector);
		frequencyThreads.shutdown();
		
		//Waits until all threads are finished before continuing
		while(!frequencyThreads.isTerminated()){
			
		}

	}

    public static void printFrequencyTableInfo(AtomicIntegerArray frequencyTable){
        //Get number of words
        float totalWords = 0;
        for(int i = 1; i < frequencyTable.length(); i++){
            totalWords = totalWords + frequencyTable.get(i);
        }
    
        //Print Frequencies
        System.out.printf("%d letter - %d words, %.2f%%\n", 1, frequencyTable.get(1), ((frequencyTable.get(1)/totalWords)*100));
         for(int i = 2; i < frequencyTable.length()-1; i++){
            float percentage = ((frequencyTable.get(i)/totalWords)*100);
            System.out.printf("%d letters - %d words, %.2f%%\n", i, frequencyTable.get(i), percentage);
        }
        System.out.printf("%d or more letter - %d words, %.2f%%\n", 8, frequencyTable.get(8), ((frequencyTable.get(8)/totalWords)*100));
    }

}