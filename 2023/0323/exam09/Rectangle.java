package exam09;

public class Rectangle extends TwoDimShape {
	private double width;
	private double height;
	
	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public void calcArea() {
		area = width*height;
	}

	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}
}
