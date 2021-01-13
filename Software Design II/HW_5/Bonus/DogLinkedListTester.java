import org.junit.*;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class DogLinkedListTester {
    private LinkedList<Dog> testList;
    private LinkedList<Dog>.Iterator<Dog> iter;

    @Before
    public void setup(){
        testList = new LinkedList<Dog>();
        Dog cinderella = new Dog("Cinderella", 15, 10);
        Dog tiana = new Dog("Tiana", 14, 10);
        Dog elsa = new Dog("Elsa", 20, 12);
        Dog mulan = new Dog("Mulan", 18, 11);

        testList.add(cinderella);
        testList.add(tiana);
        testList.add(elsa);
        testList.add(mulan);

        iter = testList.getIterator();
    }

    @Test
    public void testPrintingBackwards(){
        String testOutput = "";
        String expectedOutput = backwardsListResult();
        iter.setToEnd();
        while (iter.hasPrior()) {
            Dog foo = iter.prior();
            testOutput += foo + "\n";
        }
        assertEquals(expectedOutput, testOutput);
        System.out.println("testPrintingBackwards: passed");
    }

    @Test
    public void testContains(){
        Dog esmerelda = new Dog("Esmerelda", 16, 13);
        assertFalse(testList.contains(esmerelda));

        Dog mulanCopy = new Dog("Mulan", 18, 11);
        assertTrue(testList.contains(mulanCopy));

        System.out.println("testContains: passed");
    }

    @Test
    public void testIndexOf(){
        Dog tianaCopy = new Dog("Tiana", 14, 10);
        assertEquals(testList.indexOf(tianaCopy),1);
        System.out.println("testIndexOf: passed");
    }

    @Test
    public void testAdd(){

        Dog anna = new Dog("Anna", 17, 12);
        testList.add(anna);
        assertTrue(testList.itsLastNode.getData().equals(anna));

        Dog esmerelda = new Dog("Esmerelda", 16, 13);
        testList.add(esmerelda, 2);
        assertTrue(testList.get(2).equals(esmerelda));

        System.out.println("testAdd: passed");
    }

    @Test
    public void testBackwardsAndSetToEnd(){
        iter.prior();
        assertFalse(iter.hasPrior());

        iter.setToEnd();
        Dog mulan = new Dog("Mulan", 18, 11);
        assertEquals(iter.prior(), mulan);
        System.out.println("testBackwardsAndSetToEnd: passed");
    }

    public String backwardsListResult(){
		String result = "";
        result += "Dog: Mulan , height: 11 weight: 18\n";
        result += "Dog: Elsa , height: 12 weight: 20\n";
        result += "Dog: Tiana , height: 10 weight: 14\n";
        result += "Dog: Cinderella , height: 10 weight: 15\n";
		return result;
    }
}