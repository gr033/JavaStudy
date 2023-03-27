package exam01;

public class StartWithEndWith {
	public static void main(String[] args) {
		String data = "hello korea";
		boolean data2 = data.startsWith("hello");
		boolean data3 = data.startsWith("hi");
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data.endsWith("a"));
	}
}
