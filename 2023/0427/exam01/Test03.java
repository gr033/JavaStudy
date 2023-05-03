package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionProvider;

public class Test03 {
	public static void main(String[] args) {
		String sql = "select bookname "
				+ "from book b1 where price > (select avg(price) "
				+ "from book b2 where b1.publisher=b2.publisher group by publisher)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
