package exam07;

public class Triangle extends TwoDimShape implements Drawable {
	private double height;
	private double width;
	
	public Triangle(int x, int y, double height, double width) {
		super(x, y);
		this.height = height;
		this.width = width;
		calcArea();
	}

	public void calcArea() {
		area = (height*width)/2;
	}

	public String toString() {
		return "Triangle [height=" + height + ", width=" + width + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public void draw() {
		System.out.printf("draw Triangle, width = %.1f, height = %.1f",width,height);		
	}
}