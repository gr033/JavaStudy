package exam01;

import java.util.Random;

public class LottoTest02 {
	public static void main(String[] args) {
		Random r = new Random();
		int []n = new int[6];
		for(int i=0;i<6;) {
			int num = r.nextInt(45)+1;
			int j=0;
			for(j=0;j<i;j++) {
				if (num == n[j]) {
					break;
				}
			}
			if(j==i) {
				n[i] = num;
				i++;
			}
		}
		System.out.println("***이번주 로또 추첨번호***");
		for (int i=0;i<n.length;i++) {
			System.out.print(n[i]+" ");
		}
	}
}
