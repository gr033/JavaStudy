package exam07;
class A{
	public void pro() {
		System.out.println("A의 pro");
	}
	final public void test() {
		System.out.println("test");
	}
}
class B extends A{
	public void pro() {
		System.out.println("B의 pro");
	}
	/*
	 * public void test() { System.out.println("Btest"); }
	 */
}
public class FinalTest02 {
	public static void main(String[] args) {
		B ob = new B();
		ob.test();
	}
	
}
