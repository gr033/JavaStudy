package exam09;

public class Triangle extends TwoDimShape {
	private double height;
	private double width;
	
	public Triangle(int x, int y, double height, double width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}

	public void calcArea() {
		area = (height*width)/2;
	}

	public String toString() {
		return "Triangle [height=" + height + ", width=" + width + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}

}
