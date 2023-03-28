package exam06;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class DictionaryTest {
	public static void menu() {
		System.out.println("메뉴를 선택하세요: ");
		System.out.println("1.추가  2.검색  3.모두보기  4.삭제  5.시스템종료");
	}
	public static void addWord(Map<String, String> word) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영단어를 입력하세요: ");
		String eng = sc.next();
		System.out.print("뜻을 입력하세요: ");
		String kor = sc.next();
		if(word.containsKey(eng)) {
			System.out.println("이미 존재하는 단어입니다.");
		}else {word.put(eng, kor);}
	}
	public static void searchWord(Map<String, String> word) {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 단어를 입력하세요: ");
		String sw = sc.next();
		if(word.containsKey(sw)) {
			System.out.println("뜻: "+word.get(sw));
		}else {System.out.println("없는 단어입니다.");}
	}
	public static void printAll(Map<String, String> word) {
		Set<String> set = new LinkedHashSet<String>(word.keySet());
		for(String st:set) {
			System.out.println(st + ": "+word.get(st));
		}
		
	}
	public static void deleteWord(Map<String, String> word) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 단어를 입력하세요: ");
		String sw = sc.next();
		if(word.containsKey(sw)) {
			word.remove(sw);
			System.out.println("삭제되었습니다.");
		}else {System.out.println("없는 단어입니다.");}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String , String> word = new TreeMap<String, String>();
		int num;
		while(true) {
			menu();
			num = sc.nextInt();
			if (num==5) {
				System.out.println("시스템을 종료합니다.");
				return;
			}
			switch(num) {
				case 1: addWord(word); break;
				case 2: searchWord(word); break;
				case 3: printAll(word); break;
				case 4: deleteWord(word); break;
			}
		}
	}
}
