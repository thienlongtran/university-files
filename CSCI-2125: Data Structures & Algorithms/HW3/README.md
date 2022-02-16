# Hash Search - Homework 3

This program implements a hash function to search for a string pattern inside a target string. This can be done because the hash value of a certain string will be unique so if we find the same hash value inside of the target, then it means that the position of that value is where the pattern is located.

# Files

Search.java - The hashing and searching logic of the program.

SearchRunner.java - The runner; takes in the inputs from input.txt and displays the index at which each pattern is found or if it's not found.

input.txt - The list of patterns and targets. Each line is formatted as **pattern:target**. "end" is entered at wherever you want the program to stop searching.


## Using The Program

To use this program, follow these steps:

1. Compile all of the files through a terminal

2. Keep the provided input.txt file or modify the lines following the format **pattern:target** and ending the inputs with "end".

3. Run the input.txt file through the SearchRunner using: **java SearchRunner < input.txt**