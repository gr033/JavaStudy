package exam01;

import java.util.ArrayList;
class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add(26.7);
		list.add("grape");
		list.add("grape");
		list.add(new Person("홍길동", 20));
		list.add("banana");
		list.add("watermelon");
		list.add(100);
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println();
		for(int i=0;i<list.size();i++) {
			Object data = list.get(i);
			System.out.println(data);
		}
	}
}
