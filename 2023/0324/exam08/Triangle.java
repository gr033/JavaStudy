package exam08;

import java.util.Random;

public class Triangle extends TwoDimShape implements Movable, Drawable {
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
		Random r = new Random();
		int dx = r.nextInt(100);
		int dy = r.nextInt(100);
		x += dx;
		y += dy;
	}

	@Override
	public void move() {
		System.out.printf("draw Triangle, %.1f X %.1f\n", width, height);
	}

}
