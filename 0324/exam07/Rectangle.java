package exam07;

public class Rectangle extends TwoDimShape implements Drawable {
	private double width;
	private double height;
	
	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
		calcArea();
	}

	public void calcArea() {
		area = width*height;
	}

	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public void draw() {
		System.out.printf("draw Rectangle, width = %.1f, height = %.1f\n", width, height);		
	}
}
