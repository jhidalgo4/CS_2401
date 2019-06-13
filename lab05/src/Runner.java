/*
 * 	JOAQUIN HIDALGO
 * 	LAB 05 (RUNNER)	| 	CS 2401
 * 	
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	static String getFileName() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the full name of file to be read");
		String word = scn.nextLine();  //Scans input from user to get file name from user
		scn.close();
		return word;
	}
	
	static LinkedList readFileAndFillLinkedList(String nameOfFile){
		LinkedList list = new LinkedList();
		//Open try/catch to read file and fill Linked list
		try {
			File file = new File(nameOfFile);
			Scanner larry = new Scanner(file);
			
			while(larry.hasNextLine() ) {
				String line = larry.nextLine();
				String[] allSplits = line.split(" ");
				//Parse line and put into a 'Box'
				Box temp = new Box(Double.parseDouble(allSplits[0]),Double.parseDouble(allSplits[1]),Double.parseDouble(allSplits[2]) );
				//Add the 'Box' to the Linked List
				list.addNode(temp);
			}
			larry.close();   //Close scanner
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return list;
	}
	
	static void printAllBoxes(LinkedList list) {
		list.printAllBoxes();
	}
	
	static void printReverseAllBoxes(LinkedList list) {
		list.printReverse();
	}
	
	static void getSmallestBox(LinkedList list) {
		int counter = 0;  //Keeps track of the current position of the box
		Box minBox = list.getBox(counter);
		int minIndex = 0;
		
		while(list.getBox(counter) != null) {
			if(counter > 0) {
				//Checks current box to determine if volume is less than 'minBox'
				if (list.getBox(counter).getVolume() < minBox.getVolume() ) {
					minBox = list.getBox(counter);
					minIndex = counter;
				}	
			}
			counter++;
		}
		System.out.println("The smallest Box is: ");
		System.out.println("Index is: " + minIndex);
		System.out.printf("Volume is: %.2f\n", minBox.getVolume() );
		System.out.println(minBox.getWidth() + " x " + minBox.getLength() + " x " + minBox.getHeight() );
		System.out.println();
	}
	
	static void getBiggestBox(LinkedList list) {
		int counter = 0;  //Keeps track of the current position of the box
		Box maxBox = list.getBox(counter);
		int maxIndex = 0;
		
		while(list.getBox(counter) != null) {
			if (counter > 0) {
				//Checks current box to determine if volume is greater than 'maxBox'
				if (list.getBox(counter).getVolume() > maxBox.getVolume() ) {
					maxBox = list.getBox(counter);
					maxIndex = counter;
				}
			}
			counter++;
		}
		System.out.println("The biggest Box is: ");
		System.out.println("Index is: " + maxIndex);
		System.out.printf("Volume is: %.2f\n", maxBox.getVolume() );
		System.out.println(maxBox.getWidth() + " x " + maxBox.getLength() + " x " + maxBox.getHeight() );
		System.out.println();
	}
	
	//Dome insertNode
	public static void method6(LinkedList head) {
		LinkedList list = head;
		Box madeUp = new Box(2, 2 , 2);
		list.insertNode(madeUp, 1);
		list.printAllBoxes();
	}
	
	//Demo removeNode
	public static void method7(LinkedList head) {
		LinkedList list = head;
		list.removeNode(0);
		list.printAllBoxes();
	}
	
	public static void main(String[] args) {
		
		//Method 'fileName' takes nothing in as a parameter and returns a String which is the file name
		String fileName = getFileName();
		
		//Method 'readFileAndFillLinkedList' takes in a String the file name and returns the head of a filled linked list
		LinkedList head = readFileAndFillLinkedList(fileName);
		
		//Method 'printAllBoxes' takes in the head of the Linked list and returns nothing
		//Prints all boxes in order
		printAllBoxes(head);
		
		//Method 'printReverseAllBoxes' takes in the head of the Linked list and returns nothing
		//Prints all boxes in Reversed order
		printReverseAllBoxes(head);
		
		//Method 'getSmallestBox' takes in the head of the Linked List and returns nothing
		//Prints the smallest box of all boxes
		getSmallestBox(head);
		
		//Method 'getBiggestBox' takes in the head of the Linked List and returns nothing
		//Prints the biggest box of all boxes
		getBiggestBox(head);
		
		//DEMO INSERT NODE
		//doRemoveNode(head);
		
		//DEMO REMOVE NODE
		//doInsertNode(head);
	}
}
