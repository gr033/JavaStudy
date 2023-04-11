package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class StudentTestDelete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String name;
			System.out.println("이름 입력:");
			name = sc.next();
			String sql = "delete student where name='"+name+"'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re > 0) {
				System.out.println("삭제하였습니다.");
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