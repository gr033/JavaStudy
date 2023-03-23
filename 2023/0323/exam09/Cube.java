package exam09;

public class Cube extends ThreeDimShape {
	private double width;
	private double length;
	private double height;
	
	public Cube(int x, int y, double width, double length, double height) {
		super(x, y);
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public void calcVolume() {
		volume = width*height*length;
	}

	public String toString() {
		return "Cube [width=" + width + ", length=" + length + ", height=" + height + ", volume=" + volume + ", x=" + x
				+ ", y=" + y + "]";
	}
	

}
