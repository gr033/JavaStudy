package exam01;

public class PersonTest {

	public static void main(String[] args) {
		Person person = new Person("홍길동", 20, "서울");
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getAddr());
	}

}
