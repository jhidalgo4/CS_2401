/*
 * 	JOAQUIN HIDALGO
 * 	LAB 03 (Class file 1)	| 	CS 2401
 * 	
 */

public class Package {
	//Allocate variables
	private double height;
	private double length;
	private double width;
	
	//Deafult constructor
	Package(){
	}
	
	//Constructoring within 'runner.java'
	public Package(double h, double l, double w) {
		height = h;
		length = l;
		width = w;
	}
	
	//Returns Volume formula
	public double GetVolume() {
		return height*width*length;
	}
	
	//Returns true if package is Cubic, returns false otherwise
	public boolean isCube() {
		if(width == height && width == length) {
			return true;
		}
		return false;
	}
	
	//Gets width
	public double GetWidth() {
		return width;
	}
	
	//Gets height
	public double GetHeight() {
		return height;
	}
	
	//Gets length
	public double GetLength() {
		return length;
	}
}
