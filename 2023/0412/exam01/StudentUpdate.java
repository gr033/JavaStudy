package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

//수정할 학생의 국어, 영어, 수학을 입력받아 입력정보로 데이터베이스를 수정하는 프로그램을 작성
public class StudentUpdate {
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String name;
			int kor, eng, math;
			System.out.println("수정할 학생의 이름 입력");
			name = sc.next();
			System.out.println("국어 입력");
			kor = sc.nextInt();
			System.out.println("영어 입력");
			eng = sc.nextInt();
			System.out.println("수학 입력");
			math = sc.nextInt();
			String sql = "update student set kor="+kor+",eng="+eng+",math="+math+" where name='"+name+"'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##sist";
			String pwd = "sist";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			System.out.println("================");
			if(re>0) {
				System.out.println("수정했습니다.");
			}else {
				System.out.println("실패");
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
