import java.util.EmptyStackException;

public class CanaryStack{
    private Canary[] stack;
    private int top;

    public CanaryStack(int capacity){
        stack = new Canary[capacity];
    }

    public void push(Canary canary){
        if(top == stack.length){
            Canary[] tempArray = new Canary[2 * stack.length];
            System.arraycopy(stack, 0, tempArray, 0, stack.length);
            stack = tempArray;
        }
        stack[top++] = canary;
    }

    public Canary pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        
        Canary canary = stack[--top];
        stack[top] = null;
        return canary;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public Canary peek(){

        if(isEmpty()){
            throw new EmptyStackException();
        }

        return stack[top-1];
    }

    public void printStack(){
        for (int i = top-1; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }

    public int capacity(){
        return stack.length;
    }
}