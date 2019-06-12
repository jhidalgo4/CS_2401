/*
 * 	JOAQUIN HIDALGO
 * 	LAB 04 (Box object)	| 	CS 2401
 * 	
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner{
	
	static String getFileName() {
		System.out.println("Please enter full file name of txt file: ");
		Scanner scn = new Scanner(System.in);
		String inputFileName = scn.nextLine();
		scn.close();
		return inputFileName;
	}
	
	static Box readFileToLL(String nameOfFile) {
		Box head = new Box();
		Box lo = new Box();
		int lineCounter = 0;
		
		// Open try/Catch to read txt file
		try {
			File file = new File(nameOfFile);
			Scanner larry = new Scanner(file);
			
			//Iterate thru each line in txt file, parse text to double and fill 'LinkedList'
			while (larry.hasNextLine() ){
				String line = larry.nextLine();
				String[] allSplits = line.split(" ");
				Box temp = new Box(Double.parseDouble(allSplits[0]),Double.parseDouble(allSplits[1]),Double.parseDouble(allSplits[2]));
				
				if (lineCounter == 0) {  //Checks if we are at the beggining of the linked list
					head = temp;
					lo = temp;
				}
				else {
					lo.next = temp;
					lo = temp;
				}
				lineCounter++;
			}
			larry.close();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return head;
	}

	static void getSmallestBox(Box head){
		Box minBox = head;
		int minIndex = 0;
		int tracker = 0;
		tracker++;
		head = head.next;
		
		while (head != null) {
			// Checks if current iterator is smaller than current, 'minBox'
			if (head.getVolume() < minBox.getVolume() ) {
				minBox = head;  //Set, min box
				minIndex = tracker; //Set min box index
			}
			head = head.next;
			tracker++;
		}
		System.out.println("\nSmallest Box info:");
		System.out.println("Index is: " + minIndex);
		System.out.printf("Volume: %.2f\n" , minBox.getVolume() );
		System.out.println(minBox.getWidth() + " x " + minBox.getHeight() + " x " + minBox.getLength() );
		System.out.println();
	}
	
	static void getBiggestBox(Box head) {
		Box bigBox = head;
		int maxIndex = 0;
		int tracker = 0;
		head = head.next;
		tracker++;
		
		while(head != null) {
			// Checks if current iterator is bigger than current, 'bigBox'
			if (head.getVolume() > bigBox.getVolume() ) {
				maxIndex = tracker;  //Set max box index
				bigBox = head;  //Set max box
			}
			head = head.next;
			tracker++;
		}
		System.out.println("\nBiggest Box info: ");
		System.out.println("Index is: " + maxIndex);
		System.out.printf("Volume: %.2f\n", bigBox.getVolume() );
		System.out.println(bigBox.getWidth() + " x " + bigBox.getHeight() + " x " + bigBox.getLength() );
	}
	
	static void printNumOfCubic(Box head) {
		int cubicBoxes = 0;
		
		while(head != null) {
			if (head.isCubic() ) {
				cubicBoxes++;
			}
			head = head.next;
		}
		System.out.println("\nThe Number of cubic boxes is: " + cubicBoxes);	
	}
	
	static void getSmallestCubicBox(Box head) {
		Box minCubic = new Box();
		int minIndex = 0;
		int tracker = 0;
		
		//Iterate thru all of Linked List
		while (head != null) {
			if (head.isCubic()) { //Checks if box is cubic
				
				//Checks if minCubic is empty
				if (minCubic.getVolume() == 0){
					minCubic = head;
					minIndex = tracker;
				}
				
				//If minCubic is NOT empty
				else {  
					if (head.getVolume() < minCubic.getVolume() ) {
						minCubic = head;
						minIndex = tracker;
					}
				}
			}
			tracker++;  //Increment tracker
			head = head.next;  //Iterate to next box inside linked list
		}
		System.out.println("\nMin cubic box info: ");
		System.out.println("Index is: " + minIndex);
		System.out.printf("Volume: %.2f\n", minCubic.getVolume() );
		System.out.println(minCubic.getWidth() + " x " + minCubic.getHeight() + " x " + minCubic.getLength() );
		System.out.println();	
	}
	
	static void getBiggestCubicBox(Box head) {
		Box maxCubic = new Box();
		int maxIndex = 0;
		int tracker = 0;
		
		//Iterate thru all of Linked List
		while (head != null) {
			if (head.isCubic() ) {  //Checks if box is cubic
				
				// Checks if maxCubic is empty
				if (maxCubic.getVolume() == 0) {
					maxCubic = head;
					maxIndex = tracker;
				}
				
				//If maxCubic is NOT empty
				else {
					if (head.getVolume() > maxCubic.getVolume() ) {
						maxCubic = head;
						maxIndex = tracker;
					}
				}
			}
			tracker++;  //Increment tracker of index's
			head = head.next;  //Iterate to next box
		}
		System.out.println("Max cubic box info: ");
		System.out.println("Index is: " + maxIndex);
		System.out.printf("Volume is: %.2f\n", maxCubic.getVolume() );
		System.out.println(maxCubic.getWidth() + " x " + maxCubic.getHeight() + " x " + maxCubic.getLength() );
	}
	
	static void printAvgAllBoxes(Box head) {
		double sum = 0; // adds up all boxes in linked list
		int tracker = 0; //Adds how many boxes are being, added up
		
		//Iterate thru linked list
		while (head != null) {
			sum += head.getVolume();
			head = head.next;
			tracker++;
		}
		System.out.println("The average volume of all boxes is: " + sum/tracker);
	}
	
	static void printAvgCubicBoxes(Box head) {
		double sum = 0;  //Adds all cubic boxes volume
		int tracker =0;  //Adds how many boxes are being, added up
		
		//Iterate thru linked list
		while(head != null) {
			if (head.isCubic() ) {  //Checks if box, is Cubic
				sum += head.getVolume();
				tracker++;  //Increment number of cubic boxes
			}
			head = head.next;
		}
		System.out.println("The average volume of Cubic boxes is: " + sum/tracker);
	}
	
	public static void main(String[] args) {
		//Method 'nameTxt' takes nothing in and returns the name of txt file to be read
		String nameTxt = getFileName();
		
		//Read in text to Linked List
		//Method 'readFileToLL' makes the Linked List && reads in text file
		//Method 'readFileToLL' takes in NO parameter && returns the head of LINKED LIST called "likedList"
		Box linkedList = readFileToLL(nameTxt);
		
		//Method 'getSmallestBox' takes in parameter of head of Linked List & returns nothing
		//Finds Smallest box in Linked List & prints, Volume, Index and Dimensions
		getSmallestBox(linkedList);
		
		//Method 'getBiggestBox' takes in parameter of head of Linked List & returns nothing
		//Finds Biggest box in Linked List & prints, Volume, Index and Dimensions
		getBiggestBox(linkedList);
		
		//Method 'printNumOfCubic' takes in parameter of head of Linked List & returns nothing
		//Finds the number of cubic boxes in the Linked List
		printNumOfCubic(linkedList);
		
		//Method 'getSmallestCubicBox' takes in parameter of head of Linked List & returns nothing
		//Finds the first smallest cubic box in the Linked List
		getSmallestCubicBox(linkedList);
		
		//Method 'getBiggestCubicBox' takes in parameter of head of Linked List & returns nothing
		//Finds the first biggest cubic box in the Linked List
		getBiggestCubicBox(linkedList);
		
		//Method 'printAvgAllBoxes' takes in parameter of head of Linked List & returns nothing
		//Adds all the volumes of each box and prints the average
		printAvgAllBoxes(linkedList);
		
		//Method 'printAvgAllBoxes' takes in parameter of head of Linked List & returns nothing
		//Adds all the volumes of each Cubic box ONLY and prints the average
		printAvgCubicBoxes(linkedList);
	}
}
