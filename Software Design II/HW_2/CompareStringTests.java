/**
*@author Thien Tran
*@version 1.4
*/

import org.junit.*;
import static org.junit.Assert.*;

public class CompareStringTests{
    private String resultString;
    private int resultCompare;

    @Before
    public void setup(){
        resultString = "";
        resultCompare = 0;
    }

    @Test
    public void testFruitArray(){
        String[] fruitsOfTheWorld = {"Bananas",
                                     "Mangos",
                                     "Coconuts",
                                     "Apples",
                                     "Pears"};
        System.out.println("");
        System.out.println("Testing Fruits Array");

        resultString = CompareString.findMinimum(fruitsOfTheWorld,4);
        assertEquals(resultString,"Apples");
        System.out.println("findMinimum Result: " + resultString);

        resultCompare = CompareString.compareTo(fruitsOfTheWorld[0],fruitsOfTheWorld[4]);
        assertTrue(resultCompare < 0);
        System.out.println("compareTo Result (Bananas,Pears): " + resultCompare);

        resultCompare = CompareString.compareTo(fruitsOfTheWorld[4],fruitsOfTheWorld[0]);
        assertTrue(resultCompare > 0);
        System.out.println("compareTo Result (Pears,Bananas): " + resultCompare);
    }

    @Test
    public void testAnimalArray(){
        String[] animalsOfTheWorld = {"Cats",
                                     "Horses",
                                     "Dogs",
                                     "Cats",
                                     "Eagles",
                                     "Lions",
                                     "Elephants"};
        System.out.println("");
        System.out.println("Testing Animals Array");

        resultString = CompareString.findMinimum(animalsOfTheWorld,5);
        assertEquals(resultString,"Cats");
        System.out.println("findMinimum Result: " + resultString);

        resultCompare = CompareString.compareTo(animalsOfTheWorld[0],animalsOfTheWorld[3]);
        assertTrue(resultCompare == 0);
        System.out.println("compareTo Result (Cats,Cats): " + resultCompare);
    }
}