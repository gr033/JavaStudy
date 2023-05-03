package exam02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import db.ConnectionProvider;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("custid:");
		int custid = sc.nextInt();
		sc.nextLine();
		System.out.println("name:");
		String name = sc.nextLine();
		System.out.println("addr:");
		String addr = sc.nextLine();
		System.out.println("phone:");
		String phone = sc.nextLine();
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			CallableStatement cstmt = conn.prepareCall("{call UpdateCustomer(?,?,?,?)}");
			cstmt.setInt(1, custid);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			re = cstmt.executeUpdate();
			if(re>0) {
				System.out.println("추가");
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}