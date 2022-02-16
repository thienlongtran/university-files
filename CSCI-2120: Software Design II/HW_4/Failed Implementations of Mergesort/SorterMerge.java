    public static <T extends Comparable<T>> void merge(List<T> theList, int start, int midpoint, int end){
        int stepsCounter = start;
        int indexFirstArray = start;
        int indexSecondArray = midpoint;
        int indexLastPoint = end-1;

        while (stepsCounter < end-1){
            /*For debugging purposes
            System.out.println();
            System.out.println(theList);
            System.out.printf("T: %s --- iFA: %s --- iSA: %s\n",indexTraverser,indexFirstArray,indexSecondArray);
            System.out.println(theList.get(indexFirstArray) + " -----&---- " + theList.get(indexSecondArray));
            System.out.println("Result: "+ theList.get(indexFirstArray).compareTo(theList.get(indexSecondArray)));*/

            if(theList.get(indexFirstArray).compareTo(theList.get(indexSecondArray)) > 0){
                theList.add(indexLastPoint,theList.remove(indexSecondArray));
            }
            else if (theList.get(indexFirstArray).compareTo(theList.get(indexSecondArray)) < 0){
                theList.add(indexLastPoint,theList.remove(indexFirstArray));
                indexSecondArray--;
            }
            else if (theList.get(indexFirstArray).compareTo(theList.get(indexSecondArray)) == 0){
                theList.add(indexLastPoint,theList.remove(start));
            }
        
            stepsCounter++;
        }
        
        theList.add(indexLastPoint,theList.remove(start));

    }