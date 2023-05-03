package exam01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import db.ConnectionProvider;

public class Test02 {
	public static int addCart(int custid, int itemid, int cnt) {
		int re=-1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			CallableStatement cstmt = conn.prepareCall("{call CartInsertOrUpdate(?,?,?)}");
			cstmt.setInt(1, custid);
			cstmt.setInt(2, itemid);
			cstmt.setInt(3, cnt);
			re = cstmt.executeUpdate();
			ConnectionProvider.close(cstmt, conn);
			if(re>0) {
				System.out.println("추가(업데이트) 성공");
			}else {
				System.out.println("추가(업데이트) 실패");
			}
		}
		catch(Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return re;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("custid:");
		int custid = sc.nextInt();
		System.out.println("itemid:");
		int itemid = sc.nextInt();
		System.out.println("cnt:");
		int cnt = sc.nextInt();
		addCart(custid, itemid, cnt);
	}
}
