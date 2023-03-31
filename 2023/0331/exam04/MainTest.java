package exam04;

public class MainTest {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		Person p2 = new Person("이순신");
		Person p3 = new Person("유관순");
		p1.setPriority(1);
		p2.setPriority(Thread.MAX_PRIORITY);
		p3.setPriority(Thread.MIN_PRIORITY);
		
		p1.start();
		p2.start();
		p3.start();
	}
}
