package exam02;

import java.util.ArrayList;
import java.util.HashMap;

import dao.OrdersDAO;

public class MainTest {
	public static void main(String[] args) {
		OrdersDAO dao = new OrdersDAO();
		ArrayList<HashMap<String, Object>> list = dao.findByPublisher();
		for(HashMap<String, Object> map:list) {
			String publisher = (String)map.get("publisher");
			int count = (Integer)map.get("count");
			int sum = (Integer)map.get("sum");
			double avg = (Double) map.get("avg");
			System.out.print(publisher+"\t");
			System.out.print(count+"\t");
			System.out.print(sum+"\t");
			System.out.println(avg);
		}
	}
}
