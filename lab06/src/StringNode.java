public class StringNode { 
	
	public String head; 
	public StringNode next;

	//Default constructor
	StringNode(){
	}

	//Constructor with parameter of String
	StringNode(String s){
		head = s; 
	}
	
	//Constructor with String and next node being pointed to
	StringNode(String s, StringNode tail){ 
		head = s;
		next=tail;

	} 
}