package exam03;

import java.util.Arrays;

public class ArraysTest03 {
	public static void main(String[] args) {
		int []data = {9, 1, 10, 7, 8, 6};
		for(int i=0; i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		Arrays.sort(data);
		System.out.println();
		for(int i=0; i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
	}
}
