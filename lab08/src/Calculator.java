//Joaquin Hidalgo
//CS 2041 | Lab 08

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {
	static String getFileName() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter full name of file to be read: ");
		String userInput = scn.nextLine();
		scn.close();
		return userInput;
	}
	
	static int readFileAndCompute(String nameOfFile) {
		GenericStack stack = new GenericStack();
		int num1 = 0;
		int num2 = 0;
		int result = 0;

		try {
			File file = new File(nameOfFile);
			Scanner larry = new Scanner(file);
            int counter = 0;
            
            //While file still has lines, it will read all lines and return the total value
            while (larry.hasNextLine() ){
            	stack.popAll();
            	String expr = larry.nextLine();
            	
            	for (int i = 0; i<expr.length(); i++ ) {
            		char comparee = expr.charAt(i);
            		//comparee will test switch cases
            		
            		switch(comparee) {
            			case '0':
            				stack.push(0);
            				break;
            			case '1':
            				stack.push(1);
            				break;
            			case '2':
            				stack.push(2);
            				break;
            			case '3':
            				stack.push(3);
            				break;
            			case '4':
            				stack.push(4);
            				break;
            			case '5':
            				stack.push(5);
            				break;
            			case '6':
            				stack.push(6);
            				break;
            			case '7':
            				stack.push(7);
            				break;
            			case '8':
            				stack.push(8);
            				break;
            			case '9':
            				stack.push(9);
            				break;
            			case '+':
            				num1 = (int) stack.pop();
            				num2 = (int) stack.pop();
            				result = num2 + num1;
            				stack.push(result);
            				break;
            			case '-':
            				num1 = (int) stack.pop();
            				num2 = (int) stack.pop();
            				result = num2 - num1;
            				stack.push(result);
            				break;
            			case '*':
            				if (stack.isEmpty() ){
                                System.out.println("Empty stack");
                            }
            				num1 = (int) stack.pop();
            				num2 = (int) stack.pop();
            				result = num2 * num1;
            				stack.push(result);
            				break;
            			case '/':
            				if (stack.isEmpty() ){
                                System.out.println("Empty stack");
                            }
            				num1 = (int) stack.pop();
            				num2 = (int) stack.pop();
            				result = num2/num1;
            				stack.push(result);
            				break;
            			default:
            				System.out.println("You entered is not 0-9 or +,-,*,/");
                            break;
            		}
            	}
            	System.out.println("Line " + counter + " result is: " + stack.pop() );
                counter++;
            }
            larry.close();
            
            //if stack is empty, there was an empty file
            if (stack.isEmpty() ){
                return Integer.MIN_VALUE;
            }
            //Pop last integer in stack and return result
            else{
                result = (int)stack.pop();
                return result;
            }
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public static void main(String[] args) {
		//Method 'fileName' takes nothing in and returns a String of the file name to be read
		String fileName = getFileName();
		
		//Method 'readFileAndCompute' takes in a String 'fileName' to be read and returns integer of computed post-fix expression if any
		int answer = readFileAndCompute(fileName);
		
		//Prints out post-fix RESULT:
		System.out.println("The post-fix answer: " + answer);
	}
}
