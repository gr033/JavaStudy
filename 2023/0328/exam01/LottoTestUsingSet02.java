package exam01;

import java.util.Random;
import java.util.TreeSet;

public class LottoTestUsingSet02 {
	public static void main(String[] args) {
		Random r = new Random();
		TreeSet set = new TreeSet();
		while(set.size()!=6) {
			set.add(r.nextInt(45)+1);
		}
		System.out.println(set);
	}
}
