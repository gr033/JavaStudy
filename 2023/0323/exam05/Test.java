package exam05;

class A{
	public void pro() {
		System.out.println("A의 pro");
	}
}
class B extends A{
	int data=100;
	public void pro() {
		System.out.println(data);
		System.out.println("B의 pro");
	}
	public void test() {
		System.out.println("B의 test");
	}
}
public class Test {

	public static void main(String[] args) {
		A ob = new B();
		ob.pro();
		((B)ob).test();

	}

}
