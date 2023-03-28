package exam01;
/*
 변하는 문자열 처리에는 StringBuffer가 적합합니다.
 그러나 대부분의 문자열을 매개변수로 받는 메소드는 String으로 되어 있습니다.
 바로 호출할 수 없고 toString()메소드를 이용하여 String으로 변환 후 호출해야 합니다.
 */
public class StringBufferTest {
	public static void pro(String str) {
		System.out.println(str + "처리함");
	}
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello");
		data.append(" korea");
		System.out.println(data);
		data.insert(0, 2023);
		System.out.println(data);
		pro(data.toString());
	}
}