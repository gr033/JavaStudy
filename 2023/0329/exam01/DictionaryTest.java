package exam01;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "사과");
		map.put("orange", "오렌지");
		map.put("boy", "소년");
		Scanner sc = new Scanner(System.in);
		String eng, kor;
		System.out.println("영단어 입력: ");
		eng = sc.next();
		kor = map.get(eng);
		if (kor != null) {
			System.out.println(kor);
		}
		else {
			System.out.println("해당 단어가 존재하지 않습니다.");
		}
		
		
//		String eng = "apple";
//		String kor = map.get(eng);
//		System.out.println(kor);
		
	}
}
