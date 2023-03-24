package exam06;

import java.util.Random;

public class Circle extends TwoDimShape implements Movable {
	private double radius;
	public static final double PI =3.14;
	
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
		calcArea();
	}

	public void calcArea() {
		area =radius*radius*PI;
	}

	public String toString() {
		return "Circle [radius=" + radius + ", area=" + area + ", x=" + x + ", y=" + y + "]";
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
