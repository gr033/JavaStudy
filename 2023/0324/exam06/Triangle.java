package exam06;

import java.util.Random;

public class Triangle extends TwoDimShape implements Movable {
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
	public void move() {
		Random r = new Random();
		int dx = r.nextInt(100);
		int dy = r.nextInt(100);
		x += dx;
		y += dy;
	}

}
