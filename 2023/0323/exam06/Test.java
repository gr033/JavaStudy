package exam06;
class A{
	int i; 
	int j;
}
class B extends A{
	int k;
	public B() {
	}
	public B(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
public class Test {

	public static void main(String[] args) {
		A ob = new B();
		A ob2 = new B(2, 3, 4);

	}

}
