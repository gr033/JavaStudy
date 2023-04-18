package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;

public class BookDAO {
	public ArrayList<BookVO> findBuyBook(String name){
		ArrayList<BookVO> list = new ArrayList<>();
		String sql = "select distinct b.bookid, bookname, price, saleprice from book b, customer c, orders o "
				+ "where o.bookid=b.bookid and o.custid=c.custid and name='"+name+"'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				int price = rs.getInt(3);
				int saleprise = rs.getInt(4);
				BookVO b = new BookVO(bookid, bookname, price, saleprise);
				list.add(b);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("findBuyBook() 에러발생:"+e.getMessage());
		}
		return list;
	}
	
}
