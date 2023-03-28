package exam02;

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
		ArrayList list = new ArrayList();
		list.add(100);
		list.add("java");
		list.add(5.7);
		list.add(new Person("홍길동", 20));
		list.add(new Person("김유신", 19));
		for(Object obj:list) {
			System.out.println(obj);
			if(obj instanceof Person) {
				((Person)obj).sayHello();
			}
		}
	}
}
