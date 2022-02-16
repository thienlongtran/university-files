import java.util.NoSuchElementException;

public class CanaryArrayQueue{
    private Canary[] queue;
    private int front;
    private int back;

    public CanaryArrayQueue(int capacity){
        queue = new Canary[capacity];
    }

    public void add(Canary canary){
        if(back == queue.length){
            Canary[] tempArray = new Canary[queue.length * 2];
            System.arraycopy(queue, 0, tempArray, 0, queue.length);
            queue = tempArray;
        }
        queue[back] = canary;
        back++;
    }

    public int size(){
        return back - front;
    }

    public Canary remove(){
        if(size() == 0){
            throw new NoSuchElementException();
        }

        Canary removedCanary = queue[front];
        queue[front] = null;
        front++;

        if(size() == 0){
            front = 0;
            back = 0;
        }
        
        return removedCanary;
    }

    public Canary peek(){
        if(size() == 0){
            throw new NoSuchElementException();
        }

        return queue[front];
    }


    public void printStack(){
        for(int i = front; i < back; i++){
            System.out.println(queue[i]);
        }
    }

}