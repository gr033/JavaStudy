package exam08;

public class MainTest {

	public static void main(String[] args) {
		Circle c = new Circle(0, 0, 5);
		Rectangle r = new Rectangle(10, 10, 5, 5);
		Triangle t = new Triangle(15, 15, 10, 3);
		c.move();
		r.move();
		t.move();
		c.draw();
		r.draw();
		t.draw();
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
	}

}
