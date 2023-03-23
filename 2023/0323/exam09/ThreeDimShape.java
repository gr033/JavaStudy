package exam09;

abstract public class ThreeDimShape extends Shape {
	protected double volume;
	public abstract void calcVolume();
	public ThreeDimShape(int x, int y) {
		super(x, y);
	}
	
}
