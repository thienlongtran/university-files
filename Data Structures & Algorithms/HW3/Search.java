public class Search{

    /**
     * hashSearch hashes the pattern and the target strings and uses the hash values to search for the pattern in the target.
     * @param pattern The sequence of strings to look for.
     * @param target The string source to search for the pattern.
     * @return pPosition of the pattern in the target.
     */

    public static int hashSearch(String pattern, String target){
        int patternSize = pattern.length();
        boolean found = false;
        int patternIndex = -1;

        for(int i = 0; i < target.length()-patternSize+1; i++){
           String trimmedTarget = target.substring(i, i+patternSize);

           if(hashString(trimmedTarget) == hashString(pattern)){
                patternIndex = i;

                //Verify that the match is correct
                if(target.substring(i, i+patternSize).equals(pattern)){
                    System.out.println("Found Pattern in Target at Index: " + i);
                    found = true;
                    break;
                }
                else{
                    //Match is false
                    patternIndex = -1;
                    continue;
                }
            }
        }

           if(found == false){
            System.out.println("Pattern Not Found.");
        }

        return patternIndex;
    }

    /*
    Custom String Hashing Formula
    
    Same Logic as String.hashCode() but uses '7' instead of '31' to avoid Integer Overflow
    Allows for longer pattern recognition*/

    public static int hashString(String string){
        int hashCode = 0;

        /*
        String Hash Code Formula:
        Where x = Char ASCII value at ith string
        y = current step in summation
        String.hashCode() = x * 7^stringLength-y
        */

        for(int i = 0; i < string.length(); i++){
            hashCode = hashCode + (int)(string.charAt(i)*Math.pow(7,string.length()-(i+1)));
        }

        return (int)hashCode;
    }

}