package exam01;

import java.util.HashMap;
//HashMap은 입력한 순서를 유지하지 않음.
public class HashMapTest02 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("name", "홍길동");
		map.put("age", "20");
		map.put("phone", "010-1234-5678");
		map.put("addr", "서울");
		System.out.println(map);
	}
}
