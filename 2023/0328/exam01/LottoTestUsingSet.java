package exam01;

import java.util.Random;
import java.util.TreeSet;

public class LottoTestUsingSet {
	public static void main(String[] args) {
		Random r = new Random();
		TreeSet set = new TreeSet();
		while(true) {
			set.add(r.nextInt(45)+1);
			if(set.size()>=6) {
				break;
			}
		}
		System.out.println(set);
	}
}
