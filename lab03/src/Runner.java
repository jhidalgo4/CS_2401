/*
 * 	JOAQUIN HIDALGO
 * 	LAB 03 (Main file)	| 	CS 2401
 * 	
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Runner {
	
	static int getNumOfPackages() {
		int length =0;
		
		//Open Try/Catch to read file and get the number of packages in file
		try {
			File file = new File("input.txt");
			Scanner larry = new Scanner(file);
			while(larry.hasNextLine() ) {
				String line = larry.nextLine();
				length++;  //Increment counter by each line
			}
			larry.close();  //Close scanner
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return length;
	}
	
	static Package[] getPackagesFromFile(int lenOfFile) {
		Package[] pack = new Package[lenOfFile];
		int lineTracker = 0;
		//Open Try/Catch to read file and get the number of packages in file
		try {
			File file = new File("input.txt");
			Scanner larry = new Scanner(file);
			
			while (larry.hasNextLine() ) {
				String line = larry.nextLine();
				String[] allSplits = line.split(" ");
				
				//Parse txt file into doubles and package into 'pack'
				pack[lineTracker] = new Package(Double.parseDouble(allSplits[0]),Double.parseDouble(allSplits[1]),Double.parseDouble(allSplits[2]) );
				lineTracker++; //increment line counter
			}
			larry.close();
			for(int i =0;i<pack.length;i++) {
				System.out.println("package " + i + ": " + pack[i].GetVolume() );
			}
			
		}catch(FileNotFoundException e) {
			System.out.println(e);	
		}
		return pack;
	}
	
	static void getLargestPack(Package[] pack) {
		int indexBiggest = 0;
		double biggestVolume = pack[0].GetVolume();
		
		for (int i =1; i<pack.length;i++) {
			if (pack[i].GetVolume() > biggestVolume) {
				biggestVolume = pack[i].GetVolume();
				indexBiggest = i;
			}
		}
		System.out.println("\nIndex of largest package is: " + indexBiggest);
		System.out.println("Dimensions of the largest package is: " + pack[indexBiggest].GetWidth() + " x " + pack[indexBiggest].GetHeight() + " x " + pack[indexBiggest].GetLength() );
		System.out.println("Volume of the largest box is: " + pack[indexBiggest].GetVolume() );
		System.out.println();
	}
	
	static int printCubicAndNonCubic(int lenOfPack, Package[] pack) {
		int cubicBoxes = 0;
		for (int i =0; i< pack.length;i++) {
			if (pack[i].isCube() ) {
				cubicBoxes++;
			}
		}
		System.out.println("\nNumber of Cubic packages is: " + cubicBoxes);
		System.out.println("Number of Non-Cubic packages is: " + (lenOfPack-cubicBoxes) +"\n");
		return cubicBoxes;
	}
	
	static int[] getCubicIndices(int lenFile, int numOfCube, Package[] pack) {
		int[] cubeIndices = new int[numOfCube];
		int j =0;
		
		for (int i =0; i<pack.length;i++) {
			if (pack[i].isCube() ) {
				cubeIndices[j] = i;
				j++;
			}
		}
		
		for (int i =0; i<cubeIndices.length;i++) {
			System.out.println("Cubic box " + cubeIndices[i]);
			System.out.println("Dimensions: " + pack[cubeIndices[i]].GetHeight()+" x "+pack[cubeIndices[i]].GetWidth()+" x "+pack[cubeIndices[i]].GetLength() );
		}
		return cubeIndices;
	}
	
	static void getAverageVolumeCubic(int[] cubicInd, Package[] pack) {
		int sum =0;
		for (int i =0; i<cubicInd.length;i++) {
			sum+=pack[cubicInd[i]].GetVolume();
		}
		System.out.println("\nAverage cubic volume: " + sum/cubicInd.length);
	}

	
	public static void main(String[] args) {
		
		//Method 'lenOfFile' returns number of total packages in File
		int lenOfFile = getNumOfPackages();

		//Method 'getPackagesFromFile' uses number of total packages as a Parameter and returns an object array of Packages made in Package.java class
		//Method 'getPackagesFromFile' prints every package and its volume
		Package[] box = getPackagesFromFile(lenOfFile);
		
		//Method 'getLargestPack' uses an array of Package from Package.java class as a Parameter and returns nothing
		//Method 'getLargestPack' prints the Index of LARGEST package & Dimensions of Largest package & Volume of Largest package
		getLargestPack(box);
		
		//Method 'printCubicAndNonCubic' uses number of total packages and array Package from Package.java class as Parameters and returns number of Cubic packages only
		//Method 'printCubicAndNonCubic' prints out how many Cubic packages & how many Non-Cubic packages there are
		int numOfCubic = printCubicAndNonCubic(lenOfFile, box);
		
		//Method 'getCubicIndices' takes in lengthOfFile, NumOfCubic boxes and Package[] box and return array of indices of cubicc boxes
		int[] cubeIndices = getCubicIndices(lenOfFile, numOfCubic, box);
		
		//Method 'getAverageVolumeCubic' takes in cubeIndices, Package[] box and returns nothing
		//Prints average volume of all cubic packages
		getAverageVolumeCubic(cubeIndices, box);
		
	}

}
