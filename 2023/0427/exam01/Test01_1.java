package exam01;

import java.util.ArrayList;
import java.util.HashMap;

import com.sist.dao.BookDAO;

public class Test01_1 {
	public static void main(String[] args) {	
		BookDAO dao = new BookDAO();
		ArrayList<HashMap<String, Object>> list = dao.listBook();
		for(HashMap<String, Object> map:list) {
			String bookname = (String)map.get("bookname");
			int price = (Integer)map.get("price");
			System.out.println(bookname+","+price);
		}
	}
}
