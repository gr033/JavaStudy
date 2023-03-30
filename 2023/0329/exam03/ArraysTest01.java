package exam03;

import java.util.Arrays;

public class ArraysTest01 {
	public static void main(String[] args) {
		int[]data = new int[10];
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		Arrays.fill(data, 100);
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
	}
}
