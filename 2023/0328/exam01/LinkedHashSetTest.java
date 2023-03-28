package exam01;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet set = new LinkedHashSet();
		set.add("apple");
		set.add("grape");
		set.add("banana");
		boolean f1 = set.add("grape");
		boolean f2 = set.add("orange");
		System.out.println(set);
		System.out.println(f1);
		System.out.println(f2);
	}
}
