//학생의 이름, 국어, 영어, 수학 점수를 입력받아 출력하는 프로그램
package exam01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.swing.JLabel;

public class StudentTest_DB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, math;
		System.out.println("이름 입력");
		name = sc.next();
		System.out.println("국어");
		kor = sc.nextInt();
		System.out.println("영어");
		eng = sc.nextInt();
		System.out.println("수학");
		math = sc.nextInt();
		
		try {
			String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+")";
			
//			1.jdbc드라이버를 메모리로 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			2.db서버에 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
//			3.sql명령을 실행하기 위한 Statement객체 생성
			Statement stmt = conn.createStatement();
			
//			4.sql명령 실행
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
			System.out.println("레코드를 추가하였습니다.");
			}else {
				System.out.println("실패");
			}
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
