/*
 * 	JOAQUIN HIDALGO
 * 	LAB 02 (part 1)	| 	CS 2401
 * 	09/18/2018
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calories2 {
	
	static int CheckFileAndLength() {
		int flag = 0; //Counts the amount of errors
		
		//Open Try&Catch to read file for exactly 7 lines
		try {
			File file = new File("input2.txt");
			Scanner larry = new Scanner(file);
			String line;
			int lineCount = 0;
			while(larry.hasNextLine() ) {
				line = larry.nextLine();
				lineCount++;
				}
			larry.close(); //Close scanner
			if (lineCount != 7){
				flag++;
			}
			//Check for errors, File needs to be a 7x3 matrix of data
			if(flag >0) {
				System.out.println("ERROR MESSAGE");
                System.out.println("there are not exactly 7 lines overall");
                flag++;
			}
		}catch(FileNotFoundException e){
			System.out.println("ERROR MESSAGE");
            System.out.println("File was NOT Found");
            flag++;
		}
		return flag;
	}
	
	static int[][] GetData() {
		int[][] matrix = new int[7][];
		try {
			File file = new File("input2.txt");
			Scanner larry = new Scanner(file);
			int lineNum = 0;
			while(larry.hasNextLine() ) {
				String line = larry.nextLine();
				String[] allSplits = line.split(" ");
				matrix[lineNum] = new int[allSplits.length];
				for (int i =0; i< allSplits.length; i++) {
					matrix[lineNum][i] = Integer.parseInt(allSplits[i]);
				}
				lineNum++;
			}
			larry.close();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return matrix;
	}
	
	static int GetDailyAvgCalories(int[][] matrix) {
		System.out.println("Daily avgerage Calorie in-take");
		String[] day = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
		int longestMeal = 0;
		
		//Iterate thru 2d matrix array, add up rows and divide by length to get avg
		for(int r = 0; r<matrix.length;r++ ) {
			int tempTotal = 0;
			for (int c =0; c< matrix[r].length; c++) {
				tempTotal += matrix[r][c];
			}
			if(matrix[r].length > longestMeal) {
				longestMeal = matrix[r].length;
			}
			System.out.println(day[r] + ": " + tempTotal/matrix[r].length);
		}
		return longestMeal;
	}
	
	static void GetMealAvgCalories(int[][] matrix, int longestMeal){
		System.out.println("\nMeal Calorie average");
		int[] mealAvg = new int[longestMeal];
		int[] lengthColumn = new int[longestMeal];
		
		//Iterate thru 2d array 'matrix' to determine the amount of times eaten per meal
		for (int i =0; i<matrix.length; i++) {
			for (int j = 0; j< matrix[i].length;j++) {
				lengthColumn[j] +=1;
			}
		}
		
		//Iterate thru 2d array 'matrix' and get average calorie amount per meal
		for (int r = 0; r< matrix.length; r++) {
			for (int c = 0; c< matrix[r].length; c++) {
				mealAvg[c] += matrix[r][c];
			}
		}
		
		//Iterate thru 'mealAvg' and divide by Meal length to get the average calorie in-take
		for(int i =0;i<mealAvg.length; i++) {
			mealAvg[i] = mealAvg[i] /lengthColumn[i];
			System.out.println("Meal " + i + " avg: " + mealAvg[i]);
		}
	}
	
	public static void main(String[] args) {
		
		// Method 'CheckFileAndLength' is to check for "input.txt" and make sure its 7x3 matrix
		// Returns an integer 'flag' that counts the errors in the File size
        int flag = CheckFileAndLength();
        if (flag >0){
        	return;  //If errors found, end program
        }
        
        //Method 'GetData' reads file and returns 2d array of 'data'
        int[][] data = GetData();

        // Method 'GetDailyAvgCalories' takes in 2d array 'data' and returns nothing
        // Prints daily average calories consumed
        int longestMeal = GetDailyAvgCalories(data);
        
        //Method 'GetMealAvgCalories' takes in 2d array 'data' and returns nothing
        //Iterates thru 2d array 'data' and gets the average calorie count per meal
        GetMealAvgCalories(data, longestMeal);   
	}
}