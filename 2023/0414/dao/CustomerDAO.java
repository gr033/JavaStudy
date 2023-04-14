package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;
import vo.CustomerVO;

public class CustomerDAO {
	//insert method
	public int insertCustomer(CustomerVO c){
		int re = -1;
		String sql = "insert into customer values("+c.getCustid()+",'"+c.getName()+"','"+c.getAddress()+"','"+c.getPhone()+"')";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		} catch (Exception e) {
			System.out.println("insertCustomer() 예외발생:"+e.getMessage());
		}
		return re;
	}
	//update method
	public int updateCustomer(CustomerVO c){
		int re = -1;
		String sql = "update customer set name='"+c.getName()+"',address='"+c.getAddress()+"',phone='"+c.getPhone()+"'where custid="+c.getCustid();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		} catch (Exception e) {
			System.out.println("updateCustomer() 예외발생:"+e.getMessage());
		}
		return re;
	}
	//select method
	public ArrayList<CustomerVO> listCustomer () {
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		String sql = "select * from customer order by custid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custid = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				CustomerVO c = new CustomerVO(custid, name, address, phone);
				list.add(c);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("listCustomer() 예외발생:"+e.getMessage());
		}
		return list;	
	}
	//delete method
	public int deleteCustomer(int custid) {
		int re = -1;
		String sql = "delete customer where custid='"+custid+"'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(stmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}