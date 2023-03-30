package exam03;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		System.out.println(a); 
		int b = (int)(a%10);
		System.out.println(b);
//		Random r = new Random();
//		int n = r.nextInt()%10;
//		double a = Math.random();
//		System.out.println(a);
		
		
//		boolean f = r.nextBoolean();
//		System.out.println(f);
//		int n = r.nextInt();
//		System.out.println(n);
//		int n2 = r.nextInt(10)+1;	//10은 0~9니까 뒤에 1+해서 1~10으로함
//		System.out.println(n2);
	}
}
