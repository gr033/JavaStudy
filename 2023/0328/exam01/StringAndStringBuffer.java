package exam01;

public class StringAndStringBuffer {
	public static void main(String[] args) {
		String s1 = new String("hello");
		StringBuffer s2 = new StringBuffer("hello");
		s1 = s1+" Korea";
		s2.append(" Korea");
		System.out.println(s1);
		System.out.println(s2);
	}
}
