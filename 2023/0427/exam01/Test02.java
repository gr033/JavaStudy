package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionProvider;

public class Test02 {
	public static void main(String[] args) {
		String sql = "select publisher, nvl(sum(saleprice),0) from book b left outer join orders o \n"
				+ "on b.bookid=o.bookid group by publisher";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
