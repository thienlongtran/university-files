import java.util.List;
import java.lang.Comparable;
public class Sorters2120 {

    public static <T extends Comparable<T> > void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        while (lastToConsider > 1) {
            for (int j=0; j<lastToConsider-1; j++) {
                if (theList.get(j).compareTo(theList.get(j+1))  >  0 ) {
                    swap(theList,j,j+1);
                }
            }
            lastToConsider--;
        }
    }

    private static <T extends Comparable<T> > void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1,theList.get(i2));
        theList.set(i2,temp);
    }

    public static <T extends Comparable<T> > void selectionSort(List<T> theList) {
        //Starts sorting starting at the first element and moving upwards
       for (int i = 0; i < theList.size(); i++){

           //Assume that first element is the smallest
           int SmallestNumIndex = i;

           for(int x = i; x < theList.size(); x++){
               if(theList.get(SmallestNumIndex).compareTo(theList.get(x)) > 0){
                    SmallestNumIndex = x;
               }
           }
           swap(theList,i,SmallestNumIndex);
       }

    }

    /*public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList,0,theList.size());
    }

    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {

        // stubbed

    }

    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);

    }

    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {

        // stubbed
        return 0;

    }*/
}
