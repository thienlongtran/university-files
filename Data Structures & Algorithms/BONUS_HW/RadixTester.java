import org.junit.*;
import static org.junit.Assert.*;

public class RadixTester{

    @Test
    public void testBaseStringRadix(){
        
        String[] princesses = {"Mulan", "Belle", "Tiana", "Moana", "Ariel"};
        princesses = BaseStringRadix.sort(princesses);

        assertEquals(princesses[0],"Ariel");
        assertEquals(princesses[1],"Belle");
        assertEquals(princesses[2],"Moana");
        assertEquals(princesses[3],"Mulan");
        assertEquals(princesses[4],"Tiana");

        System.out.println("BasedStringRadix Test Passed.");

    }
    
    @Test
    public void testAdvancedStringRadix(){
        String[] princesses = {"Mulan", "Belle", "Aurora", "Pochahontas", "Merida", "Tiana", "Moana", "Ariel", "Elsa", "Anna", "Esmerelda", "Giselle", "Cinderella"};
        princesses = AdvancedStringRadix.sort(princesses);
        assertEquals(princesses[0],"Anna");
        assertEquals(princesses[1],"Ariel");
        assertEquals(princesses[2],"Aurora");
        assertEquals(princesses[3],"Belle");
        assertEquals(princesses[4],"Cinderella");
        assertEquals(princesses[5],"Elsa");
        assertEquals(princesses[6],"Esmerelda");
        assertEquals(princesses[7],"Giselle");
        assertEquals(princesses[8],"Merida");
        assertEquals(princesses[9],"Moana");
        assertEquals(princesses[10],"Mulan");
        assertEquals(princesses[11],"Pochahontas");
        assertEquals(princesses[12],"Tiana");

        System.out.println("AdvancedStringRadix Test Passed.");
    }
    

    

    public static void printStringArray(String[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println();
    }
}