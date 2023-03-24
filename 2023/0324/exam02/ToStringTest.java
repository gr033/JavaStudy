package exam02;
class Person{
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "이름: "+name+", 나이: "+age;
	}
}
public class ToStringTest {

	public static void main(String[] args) {
		int year = 2023;
		String title = "hello";
		double data = 32.7;
		Person kim = new Person("김유신", 24);
		System.out.println(year);
		System.out.println(title);
		System.out.println(data);
		System.out.println(kim);
		
	}

}
