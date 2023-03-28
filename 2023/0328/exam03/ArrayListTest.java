package exam03;

import java.util.ArrayList;

class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void sayHello() {
		System.out.println("hello, "+name);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		//list.add(100);
		list.add(new Person ("홍길동", 20));
		for(Person p:list) {
			p.sayHello();
		}
	}
}
