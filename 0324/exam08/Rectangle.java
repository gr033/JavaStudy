package exam08;

import java.util.Random;

public class Rectangle extends TwoDimShape implements Drawable, Movable{
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
	public void move() {
		Random r = new Random();
		int dx = r.nextInt(100);
		int dy = r.nextInt(100);
		x += dx;
		y += dy;
	}

	@Override
	public void draw() {
		System.out.printf("draw Rectangle, %.1f X %.1f\n", width, height);
	}
}
