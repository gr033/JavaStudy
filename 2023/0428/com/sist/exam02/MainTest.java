package com.sist.exam02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConnectionProvider;

public class MainTest {
	public static void main(String[] args) {
		String sql = "select * from month_top3";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custid = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				String phone = rs.getString(4);
				int tot = rs.getInt(5);
				System.out.println(custid+","+name+","+addr+","+phone+","+tot);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
