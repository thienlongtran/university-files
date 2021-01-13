import java.util.Scanner;

public class SearchRunner {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        while(true){
            String nextString = input.nextLine();

            //If end of text detected, then end loop
            if(nextString.equals("end")){
                System.out.println("End of Text File Detected. Goodbye!");
                break;
            }

            else{
                String[] comparisonStrings = nextString.split(":");
                System.out.printf("Pattern: %s - Target: %s\n", comparisonStrings[0], comparisonStrings[1]);
                Search.hashSearch(comparisonStrings[0], comparisonStrings[1]);
                System.out.println();
            }
        }
    }
}