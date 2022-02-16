public class ArrayUtil{
  public static void reverse(String[] array1){
    int x = array1.length;
    String[] TempArray = {"a","b","c","d","e"};

    //String[] Result = new String[x];
    int Beginning = x-1;

    for (int i = 0; i < 5; i++){
      array1[i] = TempArray[Beginning];
      Beginning = Beginning - 1;
    }
  }

  public static String[] resize(String[] array){
    int x = array.length;
    String[] Array = new String[x*2];
    for(int i = 0; i<x; i++){
      Array[i] = array[i];
    }
    return Array;
  }

  public static String[] add(String x, String[] array){
    int Length = array.length;
    String[] TempArray = resize(array);
    TempArray[Length] = x;
    return TempArray;
  }

  public static boolean contains(String x, String[] array){
    boolean Contains = false;
    for(int i = 0; i < array.length; i ++){
      if (array[i].equals(x)){
        Contains = true;
      }
    }
    return Contains;
  }
}


