package exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class WordCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		System.out.println("영어 문장 입력: ");
		line = sc.nextLine();
		HashMap<String, Integer> map = new HashMap<>();
		String []arr = line.split(" ");
		for(String word:arr) {
			Integer n = map.get(word);
			if(n != null) {
				n=n+1;
			}else {
				n = 1;
			}
			map.put(word, n);
		}
//		System.out.println(map);
		Set<String> set = map.keySet();
		System.out.println(set);
//		Set의 데이터를 하나씩 끄집어 내어 반복
//		동작시키기 위해서는 iterator사용
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String word = iter.next();
			int cnt = map.get(word);
			System.out.println(word+": "+cnt);
		}
	}
}
