package exam01;

public class SplitTest {
	public static void main(String[] args) {
		String data = "홍길동,이순신,유관순,김유신";
		String []arr = data.split(",");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
	}
}
