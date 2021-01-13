/**
* A class that models a SinglyLinkedList with add(), addByIndex(), removeByElement(),
* removeByIndex(), and toString() methods. A SinglyLinkedList "knows" only its head node.
* It contains an inner Node class. A Node object "knows" only its data (e.g., an int in this case) 
* and the next node.
*
* @author	Thien Tran
* @version	4/17/2020
*/
public class SinglyLinkedList {

	private String listName;
	private Node head;
	
	public SinglyLinkedList(String listName) {
		this.listName = listName;
		this.head = null;
	}
	
	/**
	* Returns an element specified by index from the list.
	*
	* @param	int 	index
	* @return	int		value
	*/
	public int getByIndex(int index) {
		Node current = this.head;
		
		for(int i = 0; i < index; i++){
			current = current.next;
		}

		return current.data;
	}
	
	/**
	* Adds an element to the end of the list.
	*
	* @param	int 	element
	*/
	public void add(int element) {
		Node newNode = new Node(element);
		
		if (head == null) {
			//Provide implementation where element is added at the head node.
			head = newNode;
		} else {
			//Provide implementation where element is added to a list that is not empty.
			//One way is to make the head node the tail node and "iterate" through by 
			//making the tail node's next node the new tail and then assigning the new 
			//node as the tail node's next node.
			Node tailNode = head;
			while(tailNode.next != null){
				tailNode = tailNode.next;
			}
			tailNode.next = newNode;
		}
	}
	
	/**
	* Adds an element to the list at a specified index.
	*
	* @param 	int 	index
	* @param	int 	element
	*/
	public void addByIndex(int index, int element) {
		int printIndex = index;
		Node newNode = new Node(element);
		
		if (index == 0) {
			
			//Provide implementation where the index at which to add an element is 0.
			newNode.next = head;
			head = newNode;
			//KEEP THIS LINE TO PRINT RESULT!
			System.out.println("Element " + element + " was added at index " + index + ".");
		} else {
			
			//Provide implementation where the index at which to add an element is greater than 0.
			Node currentNode = head;
			for(int i = 0; i < index-1; i++){
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			//KEEP THIS LINE TO PRINT RESULT!
			System.out.println("Element " + element + " was added at index " + printIndex + ".");
		}
	}
	
	/**
	* Removes an element from the list.
	*
	* @param	int 	element
	*/
	public void removeByElement(int element) {
		Node current = this.head;
		Node next = current.next;
		
		//If head
		if(current.data == element){
			this.head = next;
		}
		else{
			while(next.data != element && next.next != null){
				current = current.next;
				next = next.next;
			}
			
			if(next.data == element){
				current.next = next.next;
				System.out.println("Removed Element.");
			}
			else{
				System.out.println("Element not found.");
			}
		}	
	}
	
	/**
	* Removes an element specified by index from the list.
	*
	* @param	int 	index
	*/
	public void removeByIndex(int index) {
		Node current = this.head;
		Node next = current.next;;
		
		//If head
		if(index == 0){
			this.head = next;
		}
		else{
			for(int i = 0; i < index-1; i++){
				current = current.next;
				next = next.next;
			}
			current.next = next.next;
		}	
		
	}
	
	@Override
	public String toString() {
		String list = "LinkedList: ";
		Node current = this.head;  
   
        while (current != null) {  
            list = list + current.data + " "; 
            current = current.next; 
        }
		return list + "\n";
	}
	
	public class Node {
		private int data;
		private Node next;
				
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}