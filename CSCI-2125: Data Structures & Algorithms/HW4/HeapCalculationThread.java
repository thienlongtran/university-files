public class HeapCalculationThread implements Runnable{
    
    private String function;
    private String order;
    private PrincessList newPrincessList = new PrincessList();

    public HeapCalculationThread(String function, String order){
        this.function = function;
        this.order = order;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < 60; i++){

                if(this.order.equals("random")){
                    randomize();
                }

                else if (this.order.equals("reverse")){
                    sortReversePowerLevelOrder();
                }

                else{
                    sortPowerLevelOrder();
                }

                if(this.function.equals("insert")){
                    calculateInsert();
                }

                else if (this.function.equals("buildheap")){
                    calculateHeapBuild();
                }

                else{
                    System.out.println(function + " is not a valid call.");
                }

                for(int x = 0; x < 2000; x++){
                    newPrincessList.addPrincessStack();
                }
                Thread.sleep(1);
        }     
    }
        catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } 
    }

    private void sortPowerLevelOrder(){
        newPrincessList.sortPowerLevelOrder();
    }

    private void sortReversePowerLevelOrder(){
        newPrincessList.sortReversePowerLevelOrder();
    }

    private void randomize(){
        newPrincessList.randomize();
    }

    private void calculateInsert(){
        long startTime =  System.nanoTime();
        BinaryHeap princessInsertionHeap = new BinaryHeap();
        newPrincessList.getList().forEach(princess -> princessInsertionHeap.insert(princess));
        long endTime =  System.nanoTime();
        System.out.println("CalculateInsert: n = " + newPrincessList.getList().size() + " : " + (endTime-startTime)/1000000 + " milliseconds");
    }

    private void calculateHeapBuild(){
        
        long startTime =  System.nanoTime();
        Princess[] princessArray = newPrincessList.getList().toArray(new Princess[newPrincessList.getList().size()]);
        BinaryHeap princessBuildHeap = new BinaryHeap(princessArray);
        long endTime =  System.nanoTime();
        System.out.println("HeapBuild: n = " + newPrincessList.getList().size() + " : " + (endTime-startTime)/1000000 + " milliseconds");
    }
}
