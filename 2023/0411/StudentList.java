package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//모든 학생의 이름, 국어점수를 조회하여 출력하는 프로그램 작성
//select name,kor from student
public class StudentList {
	public static void main(String[] args) {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##sist";
			String password = "sist";
			String sql = "select name,kor from student";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				System.out.println(name+","+kor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		System.out.println("예외발생:"+e.getMessage());
		}
	}
}
