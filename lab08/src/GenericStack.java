
public class GenericStack {
	public Node top;
	
	//Constructor
	GenericStack(){
		top = null;
	}
	
	//Checks stack if EMPTY
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
	
    //Adds object to stack
    public void push(Object newItem){
        top = new Node(newItem, top);
    }
    
    //Removes most top node from the stack
    public Object pop(){
    	if (isEmpty() ) {
    		System.out.println("The stack is empty");
    		return null;
    	}
    	else {
    		Node temp = top;
    		top = top.next;
    		return temp.info;
    	}
    }
    
    //Removes all Nodes from stack
    public void popAll() {
    	top = null;
    }
    
    //Returns top node info from stack without poping
    public Object peek() {
    	if(isEmpty() ) {
    		System.out.println("Your stack is empty");
    		return null;
    	}
    	else {
    		return top.info;
    	}
    }
}
