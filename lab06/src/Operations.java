// Joaquin Hidalgo
// CS 2401 | Lab 06

import java.util.Random;

public class Operations {
	
	static String getRandString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
		char[] letters = new char[length];
		Random rand = new Random();
		
		//Fill String array by picking random letters from 'characters'
		for (int i = 0; i< length; i++) {
			//rand.nextInt() needs a value to know its limits to pick a random int. (0-26)
			letters[i] = characters.charAt(rand.nextInt(characters.length() ) );
		}
		
		//Combine each char from the char[] and make it into 1 string
		for(int i =0; i<length; i++) {
			result += letters[i];
		}
		
		return result;
	}
	
	/* Write a recursive method to print all the strings in separate lines.
	 * This method cannot contain any loop (that is, uses of for, while, do while are prohibited).
	*/
	public static void printMyList(StringNode m){
		//Base Case
		if (m == null) return;
		
		System.out.println(m.head);
		
		//Progress to next node
		printMyList(m.next);	
	}
	
	/* Write a recursive method to retrieve the number of strings that are longer than the
	 * length provided in the parameter. This method cannot contain any loop (that is, uses 
	 * of for, while, do while are prohibited).
	*/
	public static int countKLenghthStrings(StringNode m, int k){
		//Base Case
		if (m == null) return 0;
		
		//If string length == 'K' then you have a MATCH! return 1 + RecursiceCall (next node)
		if(m.head.length() == k) {
			return 1 + countKLenghthStrings(m.next, k);
		}
		else {
			return 0 + countKLenghthStrings(m.next, k);
		}
	}
	
	/* Write a recursive method to retrieve the largest String from the list.
	 * Assume that there is at least one String in the given list when the method is called
	 * from the main function. This method cannot contain any loop (that is, uses
	 * of for, while, do while are prohibited).
	*/
	public static String longestStringOfMyList (StringNode m){
		//Base Case
		if (m.next == null) {
			return m.head;
		}
		
		//After traversing thru LINKEDLIST, the last node string is "longest"
		String longest = longestStringOfMyList(m.next);
		
		//longest gets compared to string before the last node, return the longer string
		if (longest.length() > m.head.length() ) return longest;
		else {
			return m.head;
		}
	}
	
	/* Write a recursive method to compute the length of a list.
	This method cannot contain any loop (that is, uses of for, while, do while are prohibited).
	*/
	public static int lengthOfMyList (StringNode m){	
		//BASE CASE - once at last node, return length of that last node
		if (m.next == null ) return m.head.length();
		
		//After traversing thru LINKEDLIST, "longest" is the length of the last node
		int longest = lengthOfMyList(m.next);
		
		//Compare "longest" to Node before which is "m.head" and return the longer one
		if (longest > m.head.length() ) return longest;
		else {
			return m.head.length();
		}
	}
	
	/* Write a recursive method named reverseMyList that will reverse a given linked list m.
	 * Return the head of the reversed linked list. It is fine if you need to modify the 
	 * given linked list to obtain the reversed one. */
	public static StringNode reverseMyList (StringNode m){
		//BASE CASE - once at last node, return that node which will be the "NEW HEAD"
		if ( m==null || m.next == null) return m;
		
		//Save the node in front of the current node as iterate "high"
		StringNode high = m.next;
		
		// NewHead is now the NEW HEAD of the reversed linked list, return this @ the end
		StringNode newHead = reverseMyList(high);
		
		//Now make the High node point to the one previous to it which is, Node "m"
		high.next = m;
		
		//Since recursion saves different instance of the same problem, you can make
		//m.next point to null which is important when we are at the end of the reversed linked list...
		//The new last node will point to NULL
		m.next = null;
		
		return newHead;
	}
	
	/* Write a recursive method to remove the first occurrence of a specific String from a list.
	 * As an example, if your list initially contains AA BB CC DD BB KK and if your 
	 * removes is BB, the returned list should contain AA CC DD BB KK after the removal. 
	 * Return a new head. You must make sure that the parameter list m remains intact after 
	 * returning the new list to the main method. This method cannot contain any loop (that 
	 * is, uses of for, while, do-while are prohibited).
	*/
	public static StringNode removeAStringFromMyList(StringNode m, String removee){		
		//BASE CASE - once at the end of LINKEDLIST, return NULL/Node(m)
		//We did not find removee in the LINKEDLIST...
		if (m == null) return m;
		
		// 2nd BASE CASE - if we found the node to remove, return whatever is next to "removee" Node
		if(m.head == removee) {
			return m.next;
		}
		
		//If m != null || m != removee, MAKE NEW StringNode with constructor (see StringNode.java)
		//RecursionCall below checks if there is a NEXT valid node to point to...
		
		//NEW StringNode object is returned to make a NEW SEPERATE linkedList
		return new StringNode(m.head, removeAStringFromMyList(m.next,removee));
	}
	
	/* Write a recursive method to insert a String (insertee) into a specific position of a list.
	 * Positions start from 0 (that is, the position of the head of a list is 0).
	 * This method cannot contain any loop (that is, uses of for, while, do-while are prohibited).
	*/
	public static StringNode insertAStringIntoMyList(StringNode m, String insertee, int position){		
		// BASE CASE - Once we reach position == 0, insert the NEW node
		if (position == 0) {
			StringNode theInserteeNode = new StringNode();
			theInserteeNode.head = insertee;
			theInserteeNode.next = m;
			return theInserteeNode;
		}
		
		// Decrement  position by minus 1 (...to reach BASE CASE == 0 )
		
		// In the RecursionCall, make m.next point to the next regular Node in the LINKEDLIST or.....
		// ... Possibly make m.next point to the new "theInserteeNode" (which happens when position == 0)
		m.next = insertAStringIntoMyList(m.next, insertee, position-1);
		return m;
	}
	
	/* Write a recursive method to verify if the strings are lexicographically ordered in a linked list.
	 * Return true if they are ordered, false otherwise. This method cannot contain any loop
	 * (that is, uses of for, while, do-while are prohibited).
	*/
	public static boolean isListInOrder(StringNode m){
		
		//BASE CASE - if we reached the end of the linkedList without hitting a "false" then we are (ORDERED = return true)
		if(m == null || m.next == null) return true;
		
		//When comparing ( m.head --> to --> m.next.head) if the number is negative, then m.head comes.. 
		// ... before m.next which is what we want!  otherwise return false
		if (m.head.compareTo(m.next.head) > 0) return false;
		
		//We are good if we didn't hit a false yet, return RecursionCall with the Next Node (m.next)
		return isListInOrder(m.next);
	}
	
	/* Write a recursive method that will count how many strings of a given linked list are palindromes.
	 * The method must call another recursive method named isPalindrome to verify if a String is a palindrome, or
	not. Palindrome checks must NOT be case-sensitive. Neither countPalindromes nor isPalindrome
	may contain loops (that is, uses of for, while, do-while are prohibited).
	*/
	public static int countPalindromes(StringNode m){
		
		// BASE CASE
		if (m== null) return 0;
		
		// if Palindrome, return 1 + next recurison Call
		if (isPalindrome(m.head) == true ) {
			return  1 +countPalindromes(m.next);
		}
		// if NOT Palindrome, return 0 + next recursion Call
		else {
			return countPalindromes(m.next);
		}
	}
	
	public static boolean isPalindrome(String s){
		
		//BASE CASE - If string length is 0 or 1, return true
		if (s.length() <2 ) return true;
		
		// If 1st char != last char, NOT a Palindrome, return false
		s = s.toUpperCase();
		if (s.charAt(0) != s.charAt(s.length()-1) ) return false;
		
		// If we havnt hit a false yet, CHOP string from 1st & last char.
		// RecursionCall of the chopped up string
		return isPalindrome(s.substring(1, s.length()-1 ) );
	}

	
	public static void main(String[] args){
		
		StringNode L=new StringNode("0"+getRandString(2+(int)(Math.random()*5)));
		StringNode temp = L;
		for (int i=1; i<=9;i++){
			temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));
			temp=temp.next; 
			}
		System.out.println("All Strings in the list:");
		printMyList(L);
		System.out.println();
		
		boolean b = isListInOrder(L);
		System.out.println("List is ordered: "+b);
		System.out.println();
		
		System.out.println("Count of k-length strings");
		System.out.println("k\tNo. of Strings with length k");
		for (int k=0; k<7; k++){
			System.out.println(k+"\t"+countKLenghthStrings(L, k)); 
			}
		
		System.out.println("Longest String="+longestStringOfMyList(L));
		System.out.println("Length="+lengthOfMyList(L));
		
		L=reverseMyList(L);
		System.out.println("All string in the reversed list:");
		printMyList(L);
		System.out.println();
		

		System.out.println("Remove a given String");
		StringNode LL=removeAStringFromMyList(L, L.next.next.head);
		
		System.out.println("All strings in the new list:");
		printMyList(LL);
		System.out.println();
		
		System.out.println("All strings in the previous list:");
		printMyList(L);
		System.out.println();
		
		System.out.println("Insert a string in a position of the new list:");
		LL=insertAStringIntoMyList(LL, "Hello world", 3);
		printMyList(LL);
		System.out.println();
		
		b = isListInOrder(L);
		System.out.println("List is ordered: "+b);
		System.out.println();
		
		LL=insertAStringIntoMyList(LL, "ABBA", 3);
		LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);
		
		int c = countPalindromes(LL);
		System.out.println("Found "+c+" palindromes.");	
	}
}

