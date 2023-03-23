package exam09;

public class Cylinder extends ThreeDimShape {
	private double height;
	private double radius;
	
	public Cylinder(int x, int y, double height, double radius) {
		super(x, y);
		this.height = height;
		this.radius = radius;
	}

	public void calcVolume() {
		volume = height*radius*radius*Circle.PI;
	}

	public String toString() {
		return "Cylinder [height=" + height + ", radius=" + radius + ", volume=" + volume + ", x=" + x + ", y=" + y
				+ "]";
	}
}
