package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

import db.ConnectionProvider;

public class BookDAO {
	//새로운 도서를 등록
	public int insertBook(BookVO b){
		int re = -1;
		String sql = "insert into book(bookid, bookname, publisher, price) values(?,?,?,?)";
		try {
			int bookid = getNextBookid();
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println("insertBook 예외발생: "+e.getMessage());
		}
		return re;
	}
	//새로운 도서 번호를 반환
	public int getNextBookid() { 
		int bookid=0;
		String sql = "select nvl(max(bookid),0)+1 from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bookid = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("getNextBookid 예외발생:"+e.getMessage());
		}
		return bookid;
	}
	//모든 도서목록을 반환하는 메소드 
	public ArrayList<BookVO> listBook() {
		ArrayList<BookVO> list = new ArrayList<>();
		String sql = "select * from book order by bookid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				BookVO v = new BookVO();
				v.setBookid(bookid);
				v.setBookname(bookname);
				v.setPublisher(publisher);
				v.setPrice(price);
				list.add(v);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("bookResearch 예외발생: "+e.getMessage());
		}
		return list;
	}
}
