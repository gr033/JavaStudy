package exam03;

import java.util.Arrays;

public class ArraysTest04 {
	public static void main(String[] args) {
		int []data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int idx = Arrays.binarySearch(data, 30);
		int idx2 = Arrays.binarySearch(data, 900);
		System.out.println(idx);
		System.out.println(idx2);
	}
}
