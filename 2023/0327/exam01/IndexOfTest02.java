package exam01;
//입력한 문장에 hello를 포함하고 있는지 판별
import java.util.Scanner;

public class IndexOfTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("문장을 입력하세요");
		data = sc.nextLine();
		if (data.indexOf("hello")==-1) {
			System.out.println("hello를 포함하고 있지 않습니다.");
		}
		else {
			System.out.println("hello를 포함하고 있습니다.\n 작성문장: "+data);
		}
		sc.close();
	}
}
