import java.util.LinkedList;

public class AdvancedStringRadix{

    /**
     * Sorts the String array of strings with differing lengths using Radix Sort.
     * @param stringArray the array to be sorted.
     * @return  the sorted array.
     */
    public static String[] sort(String[] stringArray){

        int longestLength = getLongestLength(stringArray);

        for(int i = 0; i <= longestLength; i++){
            stringArray = sortDigit(stringArray, longestLength-i);
        }

        return stringArray;
        

    }

    /**
     * Sorts the String array with respect to the ASCII value of each String in the array at the location of the significant digit.
     * @param list the list to be sorted.
     * @param digitLocation the location of the digit/significant figure to sort the String array by.
     * @return a sorted String array with respect to the charecter at the location of the significant digit.
     */
    public static String[] sortDigit(String[] list, int digitLocation){
        //Initialize Linked-List Array
        LinkedList<String>[] linkedListArray = new LinkedList[26];
        for(int i = 0; i < linkedListArray.length-1; i++){
            linkedListArray[i] = new LinkedList<String>();
        }

        //Add String to linkedListArray index by relative location of ASCII value, or the the first index if value doesn't exist.
        for(int i = 0; i < list.length; i++){
            try{
                int ASCIIvalue = (int)list[i].toLowerCase().charAt(digitLocation)-97;
                linkedListArray[ASCIIvalue].add(list[i]);
            }catch(StringIndexOutOfBoundsException e){
                linkedListArray[0].add(list[i]);
            }
        }


        int currentIndex = 0;
        String[] sortedArray = new String[list.length];
        
        //Move items from linkedListArray into sortedArray.
        for(int i = 0; i < linkedListArray.length-1; i++){
            while(!linkedListArray[i].isEmpty()){
                sortedArray[currentIndex] = linkedListArray[i].removeFirst();
                currentIndex++;
            }
        }

        return sortedArray;
    }

    /**
     * Figure out the string with the longest length in the array.
     * @param list 
     * @return the max length.
     */
    public static int getLongestLength(String[] list){
        int longestLength = 0;
        for (int i = 0; i < list.length-1; i++){
            if (list[i].length() > longestLength){
                longestLength = list[i].length()-1;
            }
        }
        return longestLength;
    }

    /**
     * Print out the entire array for debugging purposes.
     * @param array the array to be printed.
     */
    public static void printStringArray(String[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println();
    }

}