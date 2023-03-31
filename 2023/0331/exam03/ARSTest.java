package exam03;

public class ARSTest {
	public static void main(String[] args) {
		Account account = new Account();
		Person p1 = new Person("홍길동", account);
		Person p2 = new Person("김유신", account);
		Person p3 = new Person("유관순", account);
		Person p4 = new Person("최치원", account);
		Person p5 = new Person("정약용", account);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		try {
			p1.join();
			p2.join();
			p3.join();
			p4.join();
			p5.join();
		} catch (Exception e) {
		}
		System.out.println();
		System.out.println("전체 모금액: "+account.getBalance());
		System.out.println();
	}
}
