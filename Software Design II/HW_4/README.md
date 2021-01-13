# Sort & Search Algorithms - Homework 4

Hello Friend!
This program is an implementation of a variety of sorting and searching algorithms. This program will allow you to sort and search through a list of any object (assuming that it's implemented Comparable correctly).

# Files

The main focus of this program will be on two files:

Sorters2120.java - Houses the implementations of the Merge Sort, Bubble Sort, Selection Sort, and Binary Search algorithms

SortersTester - the tester for the implementation


## Using The Program

To use this program, follow these steps:

1. Compile all of the files through a terminal

2. Run the tester through JUnit using: **java org.junit.runner.JUnitCore SortersTester**

## About Merge-Sort

The Merge-Sort algorithm in Sorters2120 was a difficult undertaking. I went through many different possible solutions until I found one that worked: I compare the first elements of the sorted list on each recursive call stack, and I "plucked" the smaller element and placed it on the back until there is only one element that's unsorted at the front. The front element is then the largest element in the List and is manually placed in the back. This isn't how Merge Sort is commonly done, but it works!
