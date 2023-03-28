package exam01;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedList {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		LinkedList b = new LinkedList();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(1, 40);
		
		b.add(10);
		b.add(20);
		b.add(30);
		b.add(1, 40);
		
		a.remove(2);
		b.remove(2);
		System.out.println(a);
		System.out.println(b);
	}
}