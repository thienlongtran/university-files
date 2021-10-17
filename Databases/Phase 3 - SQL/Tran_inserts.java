import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Inserts{
    //Inputs: Table Name, CSV File Name
    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("Tran_inserts.sql", true);
            BufferedWriter bw = new BufferedWriter(fw);

            //Write Commit Message if Called
            if (args[0].equals("writeCommit")){
                bw.write("COMMIT;");
                bw.close();
                System.exit(0);
            }
            
            String tableName = args[0];
            String csvName = args[1];
            File csvFile = new File(csvName);
            Scanner input = new Scanner(csvFile);
            String[] columnName = input.nextLine().split(",");

            while(input.hasNextLine()){

                String str = input.nextLine();
                String[] attributes = str.split(",");
                
                String insertCommand = "INSERT INTO " + tableName + "(" ;

                //Inserting Column Names
                for (int i = 0; i < attributes.length-1; i++){
                    insertCommand = insertCommand + columnName[i] + ",";
                }

                //Final Column Insert (Prevents Trailing Commas For Which A Solution Couldn't Be Made)
                insertCommand = insertCommand + columnName[attributes.length-1];


                insertCommand = insertCommand + ") VALUES(";
                //Inserting Values
                for(int i = 0; i < attributes.length-1; i++){
                    try{
                        //Type is a number
                        Double.parseDouble(attributes[i]);
                        insertCommand = insertCommand + attributes[i] +",";
                    }
                    catch(NumberFormatException e){
                        //Type is a string
                        insertCommand = insertCommand + "'" + attributes[i] + "',";
                    }
                }

                //Final Value Insert (Prevents Trailing Commas For Which A Solution Couldn't Be Made)
                try{
                    //Type is a number
                    Double.parseDouble(attributes[attributes.length-1]);
                    insertCommand = insertCommand + attributes[attributes.length-1];
                }
                catch(NumberFormatException e){
                    //Type is a string
                    insertCommand = insertCommand + "'" + attributes[attributes.length-1] + "'";
                }

                insertCommand = insertCommand + ");\n";
                System.out.printf("Writing To File: " + insertCommand);
                bw.write(insertCommand);
            }
            bw.close();
            input.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}