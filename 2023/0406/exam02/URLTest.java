package exam02;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

public class URLTest {

	public static void main(String[] args) {
		String str = "";
		try {
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			InputStream is = url.openStream();
			byte []arr = new byte[100];
			while(is.read(arr)!=-1) {
				str += new String(arr);
				Arrays.fill(arr, (byte)0);
			}
			is.close();
			System.out.println(str);
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}

}
