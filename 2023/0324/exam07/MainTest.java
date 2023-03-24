package exam07;
public class MainTest {
	public static void main(String[] args) {
		Circle c = new Circle(10, 10, 5);
		Rectangle r = new Rectangle(10, 20, 2, 3);
		Triangle t = new Triangle(0, 0, 12, 3);
		c.draw();
		r.draw();
		t.draw();
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
	}
}