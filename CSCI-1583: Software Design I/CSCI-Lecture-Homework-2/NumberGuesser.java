import java.util.Scanner;

public class NumberGuesser{
  public static void main(String[] args) {
  //Initialize an int variable showing the lowest number possible for a guess (starting at 0)
  int minNum = 0;

  //Initialize an int variable showing the lowest number possible for a guess (starting at 100)
  int maxNum = 100;

  //Initialize a boolean variable showing if the guess is correct (set default to false) 
  boolean correctGuess = false;

  //Initialize an int variable showing the number of steps taken (starting at 0)
  int StepsTaken = 0;

  //Declare an int variable to store user input
  int userInput;

  //Initialize an int variable showing current guess
  int currentGuess = 50;

  //Initialize a scanner object
  Scanner input = new Scanner(System.in);
  
  //Prompt user to choose a number between 0 and 100 and store it into current guess variable 
  System.out.printf("Enter your number: ");
  int UsersNum = input.nextInt();
  input.nextLine();




  //While boolean correct guess is false:
  while(correctGuess == false){

    //Present guess to the user 
  System.out.printf("Your number is: %s. Is that right?\n", currentGuess);
    //Increment amounts of steps taken
  StepsTaken += 1;

  //Ask user to type (�1 if the guess is correct, 2 if the user's number is higher, or 3 if the user�s number was lower�)
  System.out.printf("Enter '1' if the guess is correct, '2' if your number is higher, or '3' if your number was lower: ");

  //Use scanner to grab user�s input by nextInt() and store it
  userInput = input.nextInt();

  //If the user typed �1�,
  if (userInput == 1){
  //Set bootlean correct guess to true
  correctGuess = true;

  //Print the correct number and amount of steps taken
  System.out.printf("Your number is: %s!\n", currentGuess);
  System.out.printf("It took the program %s step/s to guess your number.", StepsTaken);
  //End the program
  break;
  }

  //If the user typed in �2�: 
  if (userInput == 2){
  //Set the minimum guess to the current number
  minNum = currentGuess;
  //Get new value of (CurrentGuess + maxNum) / 2
  currentGuess = (currentGuess + maxNum)/2;
  }


  //If the user typed in "3�:
    if (userInput == 3){
  //Set the maximum guess to the current number
  maxNum = currentGuess;
    //Get new value of (CurrentGuess + minNum) / 2
  currentGuess = (currentGuess + minNum)/2;
  }

    }
  }
}