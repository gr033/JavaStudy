package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.exam.vo.BoardVO;

import db.ConnectionProvider;

public class BoardDAO {
	public int getNextNo() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("getNextNo 예외발생:"+ e.getMessage());
		}
		return no;
	}
	public int insertBoard(BoardVO b) {
		int re = -1;
		String sql = "insert into board values(?, ?, ?, ?, sysdate, 0)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNextNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getId());
			pstmt.setString(4, b.getContent());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(pstmt, conn);
		} catch (Exception e) {
			System.out.println("insertBoard 예외발생:"+e.getMessage());
		}
		return re;
	}
}
