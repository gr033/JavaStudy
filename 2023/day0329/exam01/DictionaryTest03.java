package exam01;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest03 {
	public static void insertWord(HashMap<String, String> map){
		Scanner sc = new Scanner(System.in);
		String eng, kor;
		System.out.println("영단어 입력: ");
		eng = sc.next();
		eng = eng.toLowerCase();
		System.out.println("뜻 입력: ");
		kor = sc.next();
		map.put(eng, kor);
		System.out.println("단어를 사전에 등록했습니다.");
	}
	
	public static void searchWord(HashMap<String, String> map) {
		Scanner sc = new Scanner(System.in);
		String eng, kor;
		System.out.println("영단어 입력: ");
		eng = sc.next();
		eng = eng.toLowerCase();
		kor = map.get(eng);
		if (kor != null) {
			System.out.println(kor);
		}
		else {
			System.out.println("해당 단어가 존재하지 않습니다.");
		}
	}
	
	public static void deleteWord(HashMap<String, String> map) {
		Scanner sc = new Scanner(System.in);
		String eng, kor;
		System.out.println("삭제할 단어 입력: ");
		eng = sc.next();
		eng = eng.toLowerCase();
		kor = map.remove(eng);
		if(kor != null) {
			System.out.println("해당 단어를 삭제했습니다.");
		}
		else {
			System.out.println("삭제할 단어가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "사과");
		map.put("orange", "오렌지");
		map.put("boy", "소년");
		Scanner sc = new Scanner(System.in);
		String eng, kor;
		int sel;
		while(true) {
			System.out.println("메뉴를 선택하세요: ");
			System.out.println("1.추가  2.검색  3.삭제  4.종료");
			sel = sc.nextInt();
			if(sel == 4) {
				System.out.println("시스템 종료");
				break;
			}
			switch (sel) {
				case 1: insertWord(map); break;
				case 2: searchWord(map); break;
				case 3: deleteWord(map); break;
			}
		}
		
//		String eng = "apple";
//		String kor = map.get(eng);
//		System.out.println(kor);
		
	}
}