package exam01;

public class Test02 {
	public static void main(String[] args) {
		String data = new String("hello java");
		char e = data.charAt(10);
		char a = data.charAt(0);
		char b = data.charAt(4);
		char c = data.charAt(5);
		char d = data.charAt(6);
		System.out.println("|"+a+"|");
		System.out.println("|"+b+"|");
		System.out.println("|"+c+"|");
		System.out.println("|"+d+"|");
		System.out.println("|"+e+"|");
	}
}
/*
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
	at java.base/java.lang.String.charAt(String.java:1515)
	at day0327/exam01.Test02.main(Test02.java:6)
	스트링 인덱스의 범위를 넘어서 에러
 */
