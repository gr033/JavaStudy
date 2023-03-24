package exam03;
class Person{
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Person p) {
		if(name.equals(p.name)&& age==p.age) {return true;}
		else {return false;}
	}
}
public class EqualsTest {
	public static void main(String[] args) {
		Person p1 = new Person("김유신", 20);
		Person p2 = new Person("김유신", 20);
		if (p1.equals(p2)) {System.out.println("같아요");}
		else {System.out.println("달라요");}
		/*
		 * if (p1==p2) { System.out.println("같아요"); } else { System.out.println("달라요");
		 * }
		 */
		
		/*
		 * int a = 3; int b = 3; if(a==b) { System.out.println("같아요"); } else {
		 * System.out.println("달라요"); }
		 */
	}

}
