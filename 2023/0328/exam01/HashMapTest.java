package exam01;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
//		ArrayList list = new ArrayList();
//		list.add("홍길동");
//		list.add("서울시 마포구 서교동");
//		list.add(24);
/*
 위의 리스트의 경우 주소를 몇번째 인덱스에 있는지 기억하고 있기가 어렵다.
 이러한 데이터를 저장해야한다면 맵을 이용하면 좋다.
 map은 인덱스 대신에 key에 의해 데이터에 접근하는 방식.
 */
		HashMap map = new HashMap();
		map.put("name", "홍길동");
		map.put("age", 24);
		map.put("addr", "서울시 마포구 서교동");
		System.out.println(map.get("name"));
		System.out.println(map.get("addr"));
		System.out.println(map.get("age"));
		System.out.println(map);
		
	}
}
