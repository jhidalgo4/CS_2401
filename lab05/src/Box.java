/*
 * 	JOAQUIN HIDALGO
 * 	LAB 05 (Box object)	| 	CS 2401
 * 	
 */

public class Box {
	private double height;
	private double length;
	private double width;
	public Box next;
	
	Box(){
	}
	
	Box(double h, double l, double w){
		height = h;
		length = l;
		width = w;
	}
	
	public double getVolume() {
		return height*width*length;
	}
	
	public boolean isCubic() {
		return (width == length && width == height);
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
}
