package exam08;
class Person{
}
class Student{
	
}
interface A{
	int year = 2023;
	public void pro();
}
interface My{
	public void test();
}
class B extends Person implements A, My{

	public void pro() {
		System.out.println("pro");
		System.out.println(year);
	}

	public void test() {
		System.out.println("test");
	}
}
public class InterfaceTest01 {

	public static void main(String[] args) {
		B ob = new B();
		ob.pro();
	}
}
