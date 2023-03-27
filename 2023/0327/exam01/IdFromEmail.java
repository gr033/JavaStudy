package exam01;
//사용자한테 이메일을 입력받아 아이디만 추출하여 출력
import java.util.Scanner;

public class IdFromEmail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("email: ");
		String email = sc.next();
		int n = email.indexOf("@");
		System.out.println(email.substring(0, n));
		sc.close();
	}
}