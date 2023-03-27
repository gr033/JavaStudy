package exam01;

public class TrimTest {
	public static void main(String[] args) {
		String data = new String("   hello java    ");
		String data2 = data.trim();
		int x = data2.length();
		System.out.println(x);
		System.out.println("|"+data2+"|");
		System.out.println();
		int n = data.length();
		System.out.println(n);
		System.out.println("|"+data+"|");
	}

}
