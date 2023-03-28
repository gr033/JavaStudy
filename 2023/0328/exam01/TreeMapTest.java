package exam01;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap map = new TreeMap();
		map.put("name", "홍길동");
		map.put("age", "20");
		map.put("phone", "010-1234-5678");
		map.put("addr", "서울");
		System.out.println(map);
	}
}
