public class Node {
	public Node next;
	public Object info;
	
	//Default Constructor
	Node(){
	}
	
	Node(Object info, Node next){
		this.info = info;
		this.next = next;
	}
}
