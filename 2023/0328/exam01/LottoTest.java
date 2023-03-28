package exam01;

import java.util.Random;

public class LottoTest {
	public static void main(String[] args) {
		Random r = new Random();
		int []n = new int[6];
		for(int i=0;i<n.length;i++) {
			int num = r.nextInt(45)+1;
			n[i] = num;
		}
		System.out.println("***이번주 로또 추첨번호***");
		for (int i=0;i<n.length;i++) {
			System.out.print(n[i]+" ");
		}
	}
}
