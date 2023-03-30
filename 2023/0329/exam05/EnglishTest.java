package exam05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EnglishTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 문장을 입력하세요.: ");
		HashMap<String, Integer> map = new HashMap<>();
		String sent = sc.nextLine().toLowerCase();
		StringTokenizer st = new StringTokenizer(sent);
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			if(map.containsKey(key)) {
				int i = map.get(key);
				i++;
				map.put(key, i);
			}else {
				map.put(key, 1);
			}
		}
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			int n = map.get(key);
			System.out.println(key+"->"+n);
		}
	}
}