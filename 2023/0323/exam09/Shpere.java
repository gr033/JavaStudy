package exam09;

public class Shpere extends ThreeDimShape {
	private double radius;
	public Shpere(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	public void calcVolume() {
		volume = 4/3*Circle.PI*radius*radius*radius;
	}

	public String toString() {
		return "Shpere [radius=" + radius + ", volume=" + volume + ", x=" + x + ", y=" + y + "]";
	}

}
