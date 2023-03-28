package exam01;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("apple");
		set.add("grape");
		set.add("cherry");
		set.add("orange");
		boolean f1 = set.add("grape");
		boolean f2 = set.add("lemon");
		System.out.println(set);
		System.out.println(f1);
		System.out.println(f2);
	}
}
