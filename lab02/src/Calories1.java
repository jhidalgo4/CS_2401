/*
 * 	JOAQUIN HIDALGO
 * 	LAB 02 (part 1)	| 	CS 2401
 * 	09/18/2018
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Calories1 {
	
	static int CheckFileAndLength() {
		int flag = 0; //Counts the amount of errors
		
		//Open Try&Catch to read file
		try {
			File file = new File("input1.txt");
			Scanner larry = new Scanner(file);
			String line;
			int lineCount = 0;
			int error = 0;
			
			//Iterate thru file
			while(larry.hasNextLine() ) {
				line = larry.nextLine();
				String[] allSplits = line.split(" "); //Split lines by " "
				if (allSplits.length != 3) {
                    error++;
				}
				else {
					lineCount++;
				}
				if (error >0){
                    break;
				}
			}
			larry.close(); //Close scanner
			
			//Check for errors, File needs to be a 7x3 matrix of data
			if (error >0) {
				System.out.println("ERROR MESSAGE");
                System.out.println("there are not exactly three numbers on each line");
                flag++;        
			}
			else if(lineCount != 7) {
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
	
	static int[][] GetDataFromFile() {
		int[][] matrix = new int[7][3];  //Reading a file that is 7x3 matrix
		int lineNum = 0;
		
		//Open Try&Catch to read file
		try {
			File file = new File("input1.txt");
			Scanner larry = new Scanner(file);
			while (larry.hasNextLine() ) {
				String tempLine = larry.nextLine();
				String[] allSplits = tempLine.split(" ");
				matrix[lineNum][0]= Integer.parseInt(allSplits[0]);
				matrix[lineNum][1]= Integer.parseInt(allSplits[1]);
				matrix[lineNum][2]= Integer.parseInt(allSplits[2]);
				lineNum++;
			}
			larry.close();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return matrix;
	}
	
	static int[] GetDailyCalories(int[][] matrix) {
		int[] calories = new int[7];
		System.out.println("Daily Calories: ");
		String[] day = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
		
		//Iterate thru whole 'int[][] matrix' and return 'int[] calories' for daily calories
		for (int i =0; i< matrix.length;i++) {
			for(int j =0; j< matrix[i].length;j++) {
				calories[i] += matrix[i][j];
			}
		}
		for (int i =0; i< calories.length; i++) {
			System.out.println(day[i] + " " + calories[i]);		
		}
		return calories;
	}
	
	static int[] GetAvgDailyCalories(int[] dailyC) {
		int[] avgDaily = new int[7];
		System.out.println("\nAverage of daily Calories: ");
		String[] day = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
		
		//Iterate thru 'dailyC' and divide by 3 meals to get average per day
		for (int i =0; i< dailyC.length; i++) {
			avgDaily[i] = dailyC[i]/3;
			System.out.println(day[i] + " " + avgDaily[i]);
		}
		return avgDaily;
	}
	
	static void PrintMealAvg(int[][] matrix) {
		System.out.println("\nAverage Meal calories: ");
		String[] mealTime = {"Breakfast", "Lunch", "Dinner"};
		
		//Iterate thru 2d array to get average of each meal
		for(int c = 0; c< matrix[0].length; c++) {
			int tempMeal =0;
			for(int r =0; r< matrix.length; r++) {
				tempMeal += matrix[r][c];
			}
			System.out.println(mealTime[c] + " " + tempMeal/7);
		}	
	}
	
	static void GetLargestDailyCalorieMeal(int[][] matrix) {
		System.out.println("\nMax Calorie in-take per day");
		String[] mealTime = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
		int[] maxC = new int[7];
		
		//Iterate thru 2d matrix and obtain the largest integer in each row/day
		for (int i =0; i< matrix.length;i++) {
			maxC[i] = matrix[i][0];
			for(int j =1; j< matrix[i].length;j++) {
				if(matrix[i][j] > maxC[i]){
					maxC[i] = matrix[i][j];
				}
			}
			System.out.println(mealTime[i] + ": " + maxC[i]);
		}
	}
	
	static void GetLargestMealCalorie(int[][] matrix) {
		System.out.println("\nMax Calorie in-take per Meal");
		String[] mealTime = {"Breakfast", "Lunch", "Dinner"};
		int[] maxC = new int[3];
		
		for (int c = 0; c< matrix[0].length;c++) {
			maxC[c] = matrix[0][c];
			for (int r =1; r< matrix.length; r++) {
				if (matrix[r][c] > maxC[c]) {
					maxC[c] = matrix[r][c];
				}
			}
			System.out.println(mealTime[c] + ": " + maxC[c]);
		}
	}
	
	public static void main(String[] args) {
		// Method 'CheckFileAndLength' is to check for "input.txt" and make sure its 7x3 matrix
		// Returns an integer 'flag' that counts the errors in the File size
        int flag = CheckFileAndLength();
        
        if (flag >0){
        	return;  //If errors found, end program
        }
        
        // Method 'GetDataFromFile' reads "input.txt" and stores every integer into 1 big array called 'DATA'
        int[][] data = GetDataFromFile();
        
		// Method 'GetDailyCalories' uses 2D array data and returns 1D array of daily Calories 
		// Method 'GetDailyCalories' prints daily calories for each day
		int[] dailyCalories = GetDailyCalories(data);
		
		// Method 'GetAvgDailyCalories' uses daily calories as parameter && returns average calories daily
		// Method 'GetAvgDailyCalories' prints average daily calorie intake
		int[] averageCalories = GetAvgDailyCalories(dailyCalories);
		
		// Method 'PrintMealAvg' uses data as parameter && returns nothing
		// Method 'PrintMealAvg' prints breakfast/lunch/dinner total calorie intake
		PrintMealAvg(data);
		
		// Method 'GetLargestDailyCalorieMeal' uses data as parameter && returns nothing
		// Method 'GetLargestDailyCalorieMeal' prints largest amount of calorie in-take from days 1-7
		GetLargestDailyCalorieMeal(data);
		
		// Method 'GetLargestMealCalorie' uses data as parameter && returns nothing
		// Method 'GetLargestMealCalorie' prints largest calorie intake from Breakfast/Lunch/Dinner
		GetLargestMealCalorie(data);
	}

}
