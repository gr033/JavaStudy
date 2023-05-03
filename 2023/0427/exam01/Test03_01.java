package exam01;

import java.util.ArrayList;

import com.sist.dao.BookDAO;

public class Test03_01 {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		ArrayList<String> list = dao.listExpensiveBook();
		for(String bookname:list) {
			System.out.println(bookname);
		}
	}
}