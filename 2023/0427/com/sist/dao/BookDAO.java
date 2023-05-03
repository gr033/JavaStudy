package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.vo.BookVO;

import db.ConnectionProvider;

public class BookDAO {
	public ArrayList<BookVO> bookResearch(){
		ArrayList<BookVO> list = new ArrayList<>();
		String sql = "select * from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("bookInsert:"+ e.getMessage());
		}
		return list;
	}
	public int bookInsert(String name, String publisher, int price){
		int re = -1;
		try {
			String sql = "insert into book values((select max(bookid)+1 from book),?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, publisher);
			pstmt.setInt(3, price);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println("bookInsert:"+ e.getMessage());
		}
		return re;
	}
	public int changeAddress(String name, String address) {
		int r = -1;
		try {
			String sql = "update customer set column address=? where name=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			r = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return r;
	}
	public ArrayList<String> listExpensiveBook(){
		ArrayList<String> list = new ArrayList<>();
		String sql = "select bookname from book b1 where price > (select avg(price) "
				+ "from book b2 where b1.publisher=b2.publisher group by publisher)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String bookname = rs.getString(1);
				list.add(bookname);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		return list;
	}
	public ArrayList<HashMap<String, Object>> listPublisher(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		try {
			String sql = "select publisher, nvl(sum(saleprice),0) "
					+ "from book b left outer join orders o\n"
					+ "on b.bookid=o.bookid group by publisher";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String publisher = rs.getString(1);
				int total = rs.getInt(2);
				HashMap<String, Object> map = new HashMap<>();
				map.put("publisher", publisher);
				map.put("total", total);
				list.add(map);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	public ArrayList<BookVO> listBook2(){
		ArrayList<BookVO> list = new ArrayList<>();
		String sql = "select bookname, price from book where publisher ='이상미디어'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String bookname = rs.getString(1);
				int price = rs.getInt(2);
				BookVO b = new BookVO();
				b.setBookname(bookname);
				b.setPrice(price);
				list.add(b);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
		return list;
	}
	public ArrayList<HashMap<String, Object>> listBook(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		String sql = "select bookname, price from book where publisher ='이상미디어'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String bookname = rs.getString(1);
				int price = rs.getInt(2);
				HashMap<String, Object> map = new HashMap<>();
				map.put("bookname", bookname);
				map.put("price", price);
				list.add(map);
			}
			ConnectionProvider.close(rs, stmt, conn);
			
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
		return list;
	}
}