package exam01;

import java.util.HashMap;

public class MapRemoveTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "kim");
		map.put("addr", "seoul");
		map.put("phone", "010-1234-5678");
		System.out.println(map);
		String v = map.remove("age");
		String v2 = map.remove("addr");
		System.out.println(v);
		System.out.println(v2);
		System.out.println(map);
	}
}
