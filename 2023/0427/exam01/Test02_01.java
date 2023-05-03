package exam01;

import java.util.ArrayList;
import java.util.HashMap;

import com.sist.dao.BookDAO;

public class Test02_01 {
	public static void main(String[] args) {	
		BookDAO dao = new BookDAO();
		ArrayList<HashMap<String, Object>> list = dao.listPublisher();
		for(HashMap<String, Object> map : list) {
			String publisher = (String)map.get("publisher");
			int total = (Integer)map.get("total");
			System.out.println(publisher+","+total);
		}
	}
}