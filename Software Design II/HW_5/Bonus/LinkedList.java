public class LinkedList<T>  {

    Node itsFirstNode;
    Node itsLastNode;
    private int size;


    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public Iterator<T> getIterator() {
        Iterator<T> iter = new Iterator<T>(this);
        return iter;
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element) {

        Node node = new Node(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = node;
        }
        else {
            node.setPriorNode(itsLastNode);
            itsLastNode.setNextNode(node);
            itsLastNode = node;
        }
        size++;
    }

    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element, int index) {
        int counter = 0;
        Node newNode = new Node(element);
        Node current = itsFirstNode;
        while (current != null ) {
            if (counter == index - 1 )
                break;
            current = current.getNextNode();
            counter++;
        }
        newNode.setNextNode(current.getNextNode());
        newNode.setPriorNode(current);
        current.getNextNode().setPriorNode(newNode);
        current.setNextNode(newNode);
        size++;
    }

    public T get(int index) {
        int counter = 0;
        Node current = itsFirstNode;
        while (current != null ) {
            if (counter == index)
                break;
            current = current.getNextNode();
            counter++;
        }
        return current.getData();
    }

    
    // returns true if element is in the list, false if not
    public boolean contains(T element) {
        //Simple linear searching
        Node currentNode = itsFirstNode;

        //Goes through the whole list until there is no more elements
        while(currentNode != null){
            if (currentNode.getData().equals(element)){
                return true;
            }
            else{
                currentNode = currentNode.itsNext;
            }
        }

        return false;
    }

    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
        //Same logic as 'contains' method but returns index
        //Simple linear searching
        int counter = 0;
        Node currentNode = itsFirstNode;

        //Goes through the whole list until there is no more elements
        while(currentNode != null){
            if (currentNode.getData().equals(element)){
                return counter;
            }
            else{
                currentNode = currentNode.itsNext;
                counter++;
            }
        }

        return -1;
    }

    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
    public Iterator<T> iteratorAt(T element) {
        int index = indexOf(element);
        Iterator<T> iter = new Iterator(this);
        iter.setCurrentNode(index);
        return iter;
    }
    

    public String toString() {
        String returnVal = "";
        Node current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

    class Node {
    
        private T data;
        private Node itsNext;
        private Node itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node getNextNode() {
            return itsNext;
        }

        // TO BE IMPLEMENTED
        
        public Node getPriorNode() {
            return itsPrior;
        }
        
    
        public void setNextNode(Node next) {
            itsNext = next;
        }

        // TO BE IMPLEMENTED
    
        public void setPriorNode(Node prior) {
            itsPrior = prior;
        }
        
    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node

    public class Iterator<T>{

        private LinkedList<T> myList;
        private LinkedList<T>.Node myCurrentNode;

        public Iterator(LinkedList<T> list) {
            myList = list;
            myCurrentNode =  myList.itsFirstNode;
        }

        //Set the current node
        public void setCurrentNode(int index){
            for(int i = 0; i < index; i++){
                next();
            }
        }

        // return true if there is a "next" element, otherwise returns false
        public boolean hasNext() {
            if (myCurrentNode != null)
                return true;
            return false;
        }

        // return true if there is a "prior" element, otherwise returns false
        public boolean hasPrior() {
            if (myCurrentNode != null){
                return true;
            }
            else{
                return false;
            }
        }

        // returns the "next" node (really the current one) and
        // moves the Iterator forward by one node
        public T next() {
            T data = myCurrentNode.getData();
            myCurrentNode = myCurrentNode.getNextNode();
            return data;
        }

        // returns the "prior" node (really the current one) and
        // moves the Iterator backward by one node
        public T prior() {
            T data = myCurrentNode.getData();
            myCurrentNode = myCurrentNode.getPriorNode();
            return data;
        }

        // Sets this iterator to point to the last Node in the list
        
        public void setToEnd() {
            myCurrentNode = myList.itsLastNode;
        }
    }
}
