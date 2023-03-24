package exam04;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Novel(100, "용의자 X의 헌신", "히가시노 게이고");
		Book b2 = new Poet(200, "java C", "james");
		Book b3 = new ScienceFiction(300, "starwars", "someone");
		System.out.println("반납도서 정보");
		System.out.println(b1);
		System.out.println("연체료: "+b1.getLateFees(2));
		System.out.println();
		System.out.println(b2);
		System.out.println("연체료: "+b2.getLateFees(2));
		System.out.println();
		System.out.println(b3);
		System.out.println("연체료: "+b3.getLateFees(2));
		
	}

}
