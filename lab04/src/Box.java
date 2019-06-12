/*
 * 	JOAQUIN HIDALGO
 * 	LAB 04 (Box object)	| 	CS 2401
 * 	
 */

public class Box {
	public Box next;
	private double height;
	private double length;
	private double width;
	
	//Default constructor
	Box(){
	}
	
	Box(double h, double w, double l){
		height = h;
		width = w;
		length = l;
	}
	
	public boolean isCubic() {
		if (height == length && length == width) {
			return true;
		}
		return false;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getVolume() {
		return height*width*length;
	}
}
