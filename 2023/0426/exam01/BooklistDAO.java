package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;

public class BooklistDAO {
	public ArrayList<BooklistVO> bookRecommend(String name) {
		ArrayList<BooklistVO> list = new ArrayList<>();
		String sql = "select * from book where bookid in "
				+ "(select distinct bookid from "
				+ "(select distinct bookid from orders where custid in"
				+ "(select custid from (select custid, count(custid) from orders \n"
				+ "where bookid in \n"
				+ "(select bookid from orders where custid=\n"
				+ "(select custid from customer where name='"+name+"')) \n"
				+ "and custid != (select custid from customer where name='"+name+"')\n"
				+ "group by custid order by count(custid) desc) where rownum<=3)) "
				+ "where bookid not in (select bookid from orders where custid="
				+ "(select custid from customer where name='"+name+"')) \n"
				+ "union \n"
				+ "select bookid from "
				+ "(select bookid, count(*) from orders group by bookid order by count(*) desc) "
				+ "where rownum<=5 and bookid not in "
				+ "(select bookid from orders where custid=(select custid from customer where name='"+name+"')))";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				BooklistVO v = new BooklistVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(v);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("bookRecommend() 에러발생: "+ e.getMessage());
		}
		return list;
	}
}
