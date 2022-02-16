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

    public static <T extends Comparable<T> > void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList,0,theList.size());
    }

    private static <T extends Comparable<T> > void recursiveMergeSortHelper(List<T> theList, int first, int last) {
        int midpoint = (first + last) / 2; 
        
        //If there is only one element in an array, it is by default sorted
        //Goes down the stack
        if (last - first < 2){
            return;
        }

        //recursively "splits" first half of array
        recursiveMergeSortHelper(theList, midpoint, last);

        //recursively "splits" first half of array
        recursiveMergeSortHelper(theList, first, midpoint);

        //Calls the remerge method that merges the elements back again while sorting it
        remerge(theList, first, midpoint, last);
    }

    public static <T extends Comparable<T>> void remerge(List<T> theList, int start, int midpoint, int end){
        int indexTraverser = start;
        int indexFirstArray = start;
        int indexSecondArray = midpoint;

        while (indexTraverser < end && indexSecondArray < end){
            System.out.println();
            System.out.println(theList);
            System.out.printf("T: %s --- iFA: %s --- iSA: %s\n",indexTraverser,indexFirstArray,indexSecondArray);
            System.out.println(theList.get(indexFirstArray) + " -----&---- " + theList.get(indexSecondArray));
            //If the element at indexSecondArray is smaller, swap with indexTraverser
            if(theList.get(indexFirstArray).compareTo(theList.get(indexSecondArray)) > 0){
                indexFirstArray = indexSecondArray;
                swap(theList, indexTraverser, indexSecondArray);
                indexTraverser++;
                indexSecondArray++;
            }
            else{
                indexSecondArray++;
            }
            System.out.println(theList);
        }
        

    }

    public static <T extends Comparable<T> > int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size()-1);

    }

    private static <T extends Comparable<T> > int recursiveBinarySearcher(T searchItem, List<T> theList, int first, int last) {
        int midpointIndex = (last+first)/2;

        //If the searched item's value equals the midpoint, then midpoint is the index of the item in the array
        if (searchItem.compareTo(theList.get(midpointIndex)) == 0){
            return midpointIndex;
        }

        /*If there ever comes a point where the first index and the last index equals
          each other and the midpoint isn't the value, then it means that there exists
          no such element in the array.*/
        if(last == first){
            return -1;
        }

        //The two conditional statements below calls the searcher method again whilist setting either first or last as current midpoint
        //-----------------------------------------------------------------------------//
        else if (searchItem.compareTo(theList.get(midpointIndex))<0){
            return recursiveBinarySearcher(searchItem, theList, first, midpointIndex);
        }

        else if (searchItem.compareTo(theList.get(midpointIndex))>0){
            return recursiveBinarySearcher(searchItem, theList, midpointIndex+1, last);
        }
        //-----------------------------------------------------------------------------//

        return -1;

    }
}
