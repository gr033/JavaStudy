package exam03;

import java.util.Arrays;

public class ArraysTest02 {
	public static void main(String[] args) {
		boolean []data = new boolean[10];
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		Arrays.fill(data, 5, 10,true);
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
