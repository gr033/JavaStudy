package exam01;

public class SubStringTest {
	public static void main(String[] args) {
		String data = new String("hello java");
		String data1 = data.substring(3, 7);
		System.out.println(data1);
		String data2 = data.substring(3);
		System.out.println(data2);
	}
}
