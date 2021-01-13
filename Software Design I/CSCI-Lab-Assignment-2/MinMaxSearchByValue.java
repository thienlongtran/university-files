import java.util.Scanner;

public class MinMaxSearchByValue{
  public static void main(String[] args) {
    //Get the User's Input (Case Number, Followed By Sequences)
    Scanner input = new Scanner(System.in);

    //Set the number of cases
    int cases = input.nextInt();
    input.nextLine();
    //Examine the first sequence to discover the max and main
    for (int i =0; i<cases; i++){
      String sequence = input.nextLine();
      Scanner reader = new Scanner(sequence);
      int max = reader.nextInt();
      int min = max;

    //Repeat until we have a max and min for all cases

    while (reader.hasNextInt() == true){
      int number = reader.nextInt();
      if(number>max){
        max = number;
      }
      if(number < min){
        min = number;
      }
    }
    System.out.println(sequence);
    System.out.println(min);
    System.out.println(max);
    System.out.println();
    }
  }
}
