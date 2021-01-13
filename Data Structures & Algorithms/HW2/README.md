# Ball Clock - Homework 2

This program calculates the amount of days it takes for a ball clock cycle given an amount of balls present in the clock. A Linked-List backed queue concept was used to represent the main, minute, five minute, and hour queue on an actual ball clock. The program will start the clock - mimicking the functionality of an actual ball clock - and continue until all of the balls are cycled. The amount of days it takes is then displayed.

# Files

BallBearing.java - Represents each specific ball bearing in a ball clock as a position in the order which it was added to the queue.

BallClock.java - Represents the ball clock machine with all of its queues and functionality.

clockRunner.java - The runner; takes in an input (amount of balls) from a text file and outputs the cycle time.


## Using The Program

To use this program, follow these steps:

1. Compile all of the files through a terminal

2. Keep the provided input.txt file or modify the file with a list of numbers ranging from 27 to 127 and end the list with "0"

3. Run the input.txt file through the clockRunner using: **java clockRunner < input.txt**