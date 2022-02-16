/**
*@author Thien
*@version 1.6
*/

public class CompareString{

    static String currentMin = "ZZZ - Starting Calibration";
    static int result = 0;
    static int compareIndex = 0;

    static char[] alphabet
    =  {'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z'};

    /**
    *This returns the string in an array that comes first alphabetically.
    *@param stringArray this is an array of strings
    *@param numStrings this is the length of the string of array minus 1
    */
    public static String findMinimum(String[] stringArray, int numStrings){

        if (compareTo(stringArray[numStrings],currentMin) < 1){
            currentMin = stringArray[numStrings];
          }

        if(numStrings == 0){
            //Does nothing once base case is reached
        }

        else{
            findMinimum(stringArray, numStrings-1);
        }
        

        return currentMin;
    }

    /**
    *This compares two strings and return -1 if String 1 comes first, 1 if String 2 comes first, and 0 if the two are the same
    *@param s1 First string to compare to
    *@param s2 Second string to compare to
    *@return -1 if string 1 comes first, 1, if string 2 comes first, 0 if the two strings rae the same
    */
    public static int compareTo(String s1, String s2){

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(getPosition(s1) < getPosition(s2)){
            result = -1;
        }

        else if(getPosition(s1) > getPosition(s2)){
            result = 1;
        }

        else{
            try{compareIndex = compareIndex + 1;
                compareTo(s1.substring(compareIndex),s2.substring(compareIndex));}
            catch(Exception e){result = 0;}
        }

        return result;

    }

    /**
    *This returns the alphabetical index of a given string for use in the compareTo method
    *@param targetString string whose order is being calculated
    *@param numStrings this is the length of the string of array minus 1
    */
    public static int getPosition(String targetString){
        int index = 0;

        char targetChar = targetString.charAt(0);

        for (int i = 0; i < 26; i++){
            if(alphabet[i] == targetChar){
                index = i;
            }
        }

        return index;
    }
}