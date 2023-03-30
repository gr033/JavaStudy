package exam04;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("사과", 1);
		map.put("포도", 2);
		map.put("오렌지", 2);
		
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			int n = map.get(key);
			System.out.println(key+"->"+n);
		}
	}
}
