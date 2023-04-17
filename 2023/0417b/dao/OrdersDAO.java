package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import db.ConnectionProvider;
import vo.OrdersVO;

public class OrdersDAO {
	//출판사명을 매개변수로 전달받아 해당 출판사의 도서를 구매한 고객명, 
	//주소, 전화, 도서명, 도서가격, 판매가격, 금액차이, 주문일의 목록을 반환하는 메소드
	public ArrayList<HashMap<String, Object>> findAllByPublisher(String publisher){
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		String sql = "select name, address, phone, bookname, price, saleprice, price-saleprice, orderdate from book b, orders o, customer c "
				+"where b.bookid=o.bookid and o.custid=c.custid and publisher=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("name", rs.getString(1));
				map.put("address", rs.getString(2));
				map.put("phone", rs.getString(3));
				map.put("bookname", rs.getString(4));
				map.put("price", rs.getInt(5));
				map.put("saleprice", rs.getInt(6));
				map.put("price_sale", rs.getInt(7));
				map.put("orderdate", rs.getDate(8));
				list.add(map);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("findAllByPublisher() 예외발생:"+e.getMessage());
		}
		return list;
	}
	//모든 주문목록을 반환하는 메소드
	public ArrayList<OrdersVO> findAll(){
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		String sql = "select * from orders";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int orderid = rs.getInt(1);
				int custid = rs.getInt(2);
				int bookid = rs.getInt(3);
				int saleprice = rs.getInt(4);
				Date orderdate = rs.getDate(5);
				OrdersVO o = new OrdersVO(orderid, custid, bookid, saleprice, orderdate);
				list.add(o);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("findAll 예외발생:"+e.getMessage());
		}
		return list;
	}
	//출판사별로 총 판매건수, 총 판매금액, 평균판매금액을 반환하는 메소드 
	public ArrayList<HashMap<String, Object>> findByPublisher (){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "select publisher, count(*), sum(saleprice), avg(saleprice) from orders o, book b "
				+ "where o.bookid=b.bookid group by publisher";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("publisher", rs.getString(1));
				map.put("count", rs.getInt(2));
				map.put("sum", rs.getInt(3));
				map.put("avg", rs.getDouble(4));
				list.add(map);
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("findpublisher 예외발생:"+e.getMessage());
		}
		return list;
	}
}
