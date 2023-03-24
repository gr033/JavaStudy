package exam08;

public class Shape {
	protected int x;
	protected int y;
	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Shape() {
		super();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}
	
}