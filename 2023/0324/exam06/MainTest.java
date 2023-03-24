package exam06;

public class MainTest {
	public static void main(String[] args) {
		Circle c = new Circle(10, 10, 5);
		Rectangle r = new Rectangle(10, 50, 10, 20);
		Triangle t = new Triangle(10, 100, 20, 20);
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
		System.out.println();
//		c.calcArea();
//		r.calcArea();
//		t.calcArea();
		c.move();
		r.move();
		t.move();
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
	}

}
