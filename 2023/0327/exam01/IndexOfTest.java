package exam01;

public class IndexOfTest {
	public static void main(String[] args) {
		String data = "hello korea";
		int n = data.indexOf('e');
		int n2 = data.indexOf("e");
		System.out.println(n);
		System.out.println(n2);
		int n3 = data.lastIndexOf('e');
		int n4 = data.lastIndexOf("e");
		System.out.println(n3);
		System.out.println(n4);
		int n5 = data.indexOf("korea");
		System.out.println(n5);
		int n6 = data.indexOf("kim");
		System.out.println(n6);
	}
}
