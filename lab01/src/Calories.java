/*
 * 	JOAQUIN HIDALGO
 * 	LAB 01 	| 	CS 2401
 * 	09/07/2018
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Calories{

	static int CheckFileAndLength() {
		int flag = 0; //Counts the amount of errors
		
		//Open Try&Catch to read file
		try {
			File file = new File("input.txt");
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
	
	static int[] GetDataFromFile() {
		int[] matrix = new int[21]; //set int array to 21 because of the 7x3 matrix
		
		//Open Try&Catch to read file
		try {
			File file = new File("input.txt");
			Scanner larry = new Scanner(file);
			
			//Read all 21 elements in the File
			for (int i =0; i< 21; i++) {
				matrix[i] = larry.nextInt();
			}
			larry.close();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return matrix;
	}
	
	static int[] GetBreakfastCalories(int[] matrix) {
		int[] bf = new int[7];
		int trak =0;
		
		// Load every breakfast calorie into, int[] bf
		for (int i =0; i<matrix.length;i=i+3) {
			bf[trak]= matrix[i];
			trak++;
		}
		return bf;	
	}
	
	static int[] GetLunchCalories(int[] matrix) {
		int[] lunch = new int[7];
		int trak = 0;
		
		// Load every breakfast calorie into, int[] lunch
		for (int i =1; i<matrix.length;i=i+3) {
			lunch[trak] = matrix[i];
			trak++;
		}
		return lunch;
	}
	
	static int[] GetDinnerCalories(int[] matrix) {
		int[] dinner = new int[7];
		int trak =0;
		
		// Load every breakfast calorie into, int[] dinner
		for (int i =2; i<matrix.length;i=i+3) {
			dinner[trak] = matrix[i];
			trak++;
		}
		return dinner;
	}
	
	static int[] GetDailyCalories(int[] bf, int[] lun, int[] din) {
		int[] sum = new int[7];
		System.out.println("Total Daily Calories: ");
		
		//Add every same element of breakfast, lunch, dinner to keep track of daily calories
		for (int i =0; i< bf.length;i++) {
			System.out.print("day " + i + " ");
			sum[i] = bf[i] + lun[i] + din[i];
			System.out.print(sum[i] + "\n");
		}
		return sum;
	}
	
	static void GetDaysOverConsumer(int[] calories) {
		System.out.println("\n Days Calories exceed 2,250:");
		String[] day = {"Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"};
		
		// Calories that exceed 2,250, print corresponding day to that calorie in-take
		for (int i =0; i< calories.length;i++) {
			if (calories[i] > 2250) {
				System.out.println(day[i]);
			}
		}
	}
	
	static void GetAvgMeals(int[] bf, int[] lun, int[] din) {
		int[] avgCalMeal = new int[3];
		
		// Add every Calorie in-take to bf, lunch or dinner
		for (int i =0; i< bf.length;i++) {
			avgCalMeal[0] += bf[i];
			avgCalMeal[1] += lun[i];
			avgCalMeal[2] += din[i];
		}
		avgCalMeal[0] = avgCalMeal[0]/7;
		System.out.println("\nYour average calories for Breakfast is: " + avgCalMeal[0] );
		avgCalMeal[1] = avgCalMeal[1]/7;
		System.out.println("Your average calories for Lunch is: " + avgCalMeal[1] );
		avgCalMeal[2] = avgCalMeal[2]/7;
        System.out.println("Your average calories for Dinner is: " + avgCalMeal[2] );
	}
	
	public static void main(String[] args) {
		// Method 'CheckFileAndLength' is to check for "input.txt" and make sure its 7x3 matrix
		// Returns an integer 'flag' that counts the errors in the File size
        int flag = CheckFileAndLength();
        
        if (flag >0){
        	return;  //If errors found, end program
        }
        
        // Method 'GetDataFromFile' reads "input.txt" and stores every integer into 1 big array called 'DATA'
        int[] data = GetDataFromFile();

        // Method 'GetBreakfastCalories' takes in, int[] DATA as a parameter and returns the column of the text
        // 			...associated with the text file known as, int[] BREAKFAST
        int[] breakfast = GetBreakfastCalories(data);
        
        // Method 'GetLunchCalories' takes in, int[] DATA as a parameter and returns the column of the text
        // 			...associated with the text file known as, int[] Lunch
        int[] lunch = GetLunchCalories(data);
        
        // Method 'GetDinnerCalories' takes in, int[] DATA as a parameter and returns the column of the text
        // 			...associated with the text file known as, int[] Dinner
        int[] dinner = GetDinnerCalories(data);
        
        // Method 'GetDailyCalories' takes in BREAKFAST, LUNCH, DINNER array's & returns DAILYCALORIES
        // This method adds each DAY from breakfast, lunch and dinner for total calories
        // 			... and PRINTS total calories consumed each day
        int[] dailyCal = GetDailyCalories(breakfast, lunch, dinner);
        
        // Method 'GetDaysOverConsumer' takes in DAILYCALORIES & returns nothing
        // Method 'GetDaysOverConsumer' PRINTS the days you consumed more than 2,250 calories
        GetDaysOverConsumer(dailyCal);
        
        // Method 'GetAvgMeals' takes in BREAKFAST, LUNCH, DINNER & returns nothing
        // Method 'GetAvgMeals' PRINTS average calories for breakfast, lunch and dinner
        GetAvgMeals(breakfast, lunch, dinner);
	}
}