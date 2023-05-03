package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.vo.CustomerVO;

import db.ConnectionProvider;

public class CustomerDAO {
	//고객명과 주소를 매개변수로 전달받아 해당 고객의 주소를 변경한느 메소드를 정의
	public int updateAddr(String name, String addr) {
		int re = -1;
		try {
			String sql = "update customer set address=? where name=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, name);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println("updateAddr 예외발생"+e.getMessage());
		}
		return re;
	}
	//이름을 매개변수로 전달받아 주소와 전화번호를 검색하여 반환하는 메소드를 정의
	public CustomerVO getCustomer(String name) {
		CustomerVO c = new CustomerVO();
		String sql = "select address, phone from customer where name=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String address = rs.getString(1);
				String phone = rs.getString(2);
				c.setAddress(address);
				c.setPhone(phone);
			}
		} catch (Exception e) {
			System.out.println("getCustomer 예외발생"+e.getMessage());
		}
		return c;
	}
}
