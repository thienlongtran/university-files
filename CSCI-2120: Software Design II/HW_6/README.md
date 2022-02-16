# Series Calculator - Concurrency Bonus Homework

A series is the sum of a mathematical function from a starting point to an ending point. For example: given f(x), we can make a series starting at f(0) to f(n) and the value would be f(0)+f(1)+f(2)+...+f(n)


Certain series, such as one of the ones in this program, could be calculation intensive and take a long time to compute if the end point is far from the start point. However, concurrency can be used to find the f(n) at different values on different threads. This can exponentially reduce total computation time.


This program shows an example of a calculation-intensive series being calculated starting at {n=0 to 5000} and it displays the difference in calculation time - showing that concurrency can make certain programs faster.


## Using The Program

To use this program, follow these steps:

1. Compile all of the files through a terminal using: javac *.java

2. Run the tester through JUnit using: **java org.junit.runner.JUnitCore SeriesTester**
