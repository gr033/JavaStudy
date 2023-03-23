package exam09;

public abstract class TwoDimShape extends Shape {
	protected double area;
	public abstract void calcArea();
	public TwoDimShape(int x, int y) {
		super(x, y);
	}
}
