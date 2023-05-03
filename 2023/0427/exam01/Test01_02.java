package exam01;

import java.util.ArrayList;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class Test01_02 {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = dao.listBook2();
		for(BookVO b:list) {
			System.out.println(b.getBookname()+","+b.getPrice());
		}
	}
}
