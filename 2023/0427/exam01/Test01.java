package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionProvider;

public class Test01 {
	public static void main(String[] args) {
		try {
			String sql = "select bookname, price "
					+ "from book where publisher='이상미디어'";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getInt(2));
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
		}
	}
}
