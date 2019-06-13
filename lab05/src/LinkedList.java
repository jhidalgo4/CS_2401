/*
 * 	JOAQUIN HIDALGO
 * 	LAB 05 (LINKED LIST)	| 	CS 2401
 * 	
 */

public class LinkedList {
	private Box head;
	private Box iterator;
	
	LinkedList(){
	}

	/* Add b as the last node of the linked list.*/
	void addNode(Box b) {
		if (head == null) {
			head = b;
			iterator = head;
		}
		else {
			iterator.next = b;
			iterator = iterator.next;
		}
	}
	
	/* Insert b in position pos. If insertion is successful * return true, otherwise return false.*/
	//method still needs work.....
	boolean insertNode(Box b, int pos){
		Box inserte = b;
		
		if (head == null ) {
			if (pos == 0) {
				head = inserte;
				iterator = head;
				return true;
			}
			else{
				return false;
			}
		}
		
		else if (pos < 0) return false;
		
		else if (pos == 0) {
			inserte.next = head;
			head = inserte;
		}
		
		//If pos is >= 1
		else {
			int count = 0; 
			iterator = head;
			//Add while loop to continue until iter == null because we need to increment thru LL
			while ( iterator != null ) {
				if (count == (pos-1) ) {
					//you are now at the node that needs to be connected to 'b'. 
					//before swapping check if new node being inserted is gonna be the last node or not last
					//if last node, dont use temp
					//if its not the last node, dont use temp
					if(iterator.next == null) {
						iterator.next = inserte;
						iterator = iterator.next;
						return true;
					}
					else if (iterator.next != null) {
						Box temp = new Box();
						temp = iterator.next;
						iterator.next = inserte;
						inserte.next = temp;
						iterator = iterator.next.next;
						while (iterator.next != null  ) {
							iterator = iterator.next;
						}
						return true;
					}
				}
				//if your not at your desired node, continue to get to the last node;
				if (iterator.next != null) {
					count++;
					iterator = iterator.next;
				}
				if (iterator == null && (count < (pos-1)) ) {
					//we were not able to add the node
					return false;
				}
			}
			return false;
		}
		return false;
	}
	
	/**Print width, height, length, and volume of each of the boxes in * this linked list. */
	void printAllBoxes(){
	      if (head == null) System.out.println("null");
	      else {
	    	  System.out.println("\nPrint all Boxes: ");
	    	  iterator = head;
	    	  int count = 0;
	    	  while (iterator != null) {
	    		  System.out.println("Box " + count + ":");
	    		  System.out.println("Dimensions: " + iterator.getWidth() +" x "+ iterator.getLength() +" x "+ iterator.getHeight() );
	    		  System.out.println("Volume: " + iterator.getVolume() );
	    		  System.out.println();
	    		  iterator = iterator.next;
	    		  count++;
	    	  }
	      }
	  }
	
	/** Remove the box in position pos. Return true if removal * is successful, otherwise return false.*/
	boolean removeNode(int pos){
		if (head == null) return false;
		if (pos < 0) return false;
		
		else if (pos == 0) {
			if (head.next == null) {
				head = null;
			}
			else {
				head = head.next;
			}
		}
		
		else{
			iterator = head;
			int count = 0;
			while (iterator != null) {
				if (count == pos-1) {
					if (iterator.next.next == null) {
						iterator.next = null;
					}
					else if (iterator.next.next != null) {
						iterator.next = iterator.next.next;
						iterator = iterator.next;
					}
				}
				
				if (iterator.next != null) {
					count++;
					iterator= iterator.next;
				}
				
				if (iterator.next == null && (count < (pos-1)) ) {
					//we were not able to add the node
					return false;
				}
			}
			return false;
		}
		return false;
	  }
	
	/** Return the box in position pos. Return null when pos is * invalid.*/
	Box getBox(int pos){
		//use temp instead of iterator that way iterator stays at the end always
		Box temp = new Box();
		if (head == null) {
			return null;
		}
		
		else if (pos < 0) {
			return null;
		}
		
		else if (pos == 0) {
			return head;
		}
		
		else {
			temp = head;
			int count = 0;
			
			while (temp != null) {
				if (count == pos ) {
					return temp;
					
				}
				if (temp.next != null) {
					count++;
					temp = temp.next;
				}
				
				if (temp.next == null && count < pos) {
					return null;
				}
				
			}
		}
		return null;  //nothing should happen
	  }
	
	/**Print width, height, length, and volume of each of the boxes in * this linked list in reverse order.*/
	void printReverse() {
		if (head == null) System.out.println("null");
		
		else {
			iterator = head;
			Box prev = new Box(iterator.getWidth() , iterator.getLength() , iterator.getHeight() );
			Box temp = prev;
			iterator = iterator.next;
			int count = 0;
			while (iterator != null) {
				temp = new Box(iterator.getWidth() , iterator.getLength() , iterator.getHeight() );
				temp.next = prev;
				prev = temp;
				iterator = iterator.next;
				count++;
			}
			
			System.out.println("\nPrint Boxes in Reverse order: ");
			while (temp != null) {
				System.out.println("Box " + count + ": ");
				System.out.println("Dimensions: " + temp.getWidth()+" x "+ temp.getLength()+" x "+ temp.getHeight() );
				System.out.println("Volume: " + temp.getVolume() );
				System.out.println();
				temp = temp.next;
				count--;
			}
		}
	}
	
	/**Initiate the iterator variable*/
	void initiateIterator(){
		iterator = head;
	}
	
	/*** Return the box in the current iterator position. */
	Box getNextBox(){
		iterator = iterator.next;
		return iterator;
	}
}
