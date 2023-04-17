package exam01;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dao.OrdersDAO;
import vo.OrdersVO;

public class MainTest {
	
	public static void main(String[] args) {
		OrdersDAO dao = new OrdersDAO();
		ArrayList<OrdersVO> list = dao.findAll();
		for(OrdersVO o:list) {
			int orderid = o.getBookid();
			int custid = o.getCustid();
			int bookid = o.getBookid();
			int saleprice = o.getSaleprice();
			Date orderdate = o.getOrderdate();
			System.out.print(orderid+"\t");
			System.out.print(custid+"\t");
			System.out.print(bookid+"\t");
			System.out.print(saleprice+"\t");
			System.out.println(orderdate+"\t");
		}
	}
}
