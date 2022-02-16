public class CanaryNode{
    private Canary current;
    private Canary next;

    public CanaryNode(Canary current){
        this.current = current;
    }

    public Canary getCurrent() {
        return this.current;
    }

    public void setCurrent(Canary current) {
        this.current = current;
    }

    public Canary getNext() {
        return this.next;
    }

    public void setNext(Canary next) {
        this.next = next;
    }


}