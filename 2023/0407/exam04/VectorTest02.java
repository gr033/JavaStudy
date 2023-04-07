package exam04;

import java.util.ArrayList;

public class VectorTest02 {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		
		row1.add("홍길동");
		row1.add("100");
		row1.add("80");
		row1.add("90");
		
		row2.add("김유신");
		row2.add("50");
		row2.add("40");
		row2.add("80");
		
		list.add(row1);
		list.add(row2);
		System.out.println(list);
		
		ArrayList<String> c = new ArrayList<String>();
		c.add("홍길순");
		c.add("홍길동");
		c.add("홍길목");
		c.add("홍길옥");
		
		list.set(0, c);
		System.out.println(list);
		
	}

}
