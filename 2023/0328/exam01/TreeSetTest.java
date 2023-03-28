package exam01;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add("grape");
		set.add("apple");
		set.add("banana");
		System.out.println("데이터 수: "+set.size());
		boolean f1 = set.add("grape");
		boolean f2 = set.add("gam");
		System.out.println(set);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println("데이터 수: "+set.size());
	}
}
