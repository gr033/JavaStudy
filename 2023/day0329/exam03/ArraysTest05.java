package exam03;

import java.util.Arrays;

public class ArraysTest05 {
	public static void main(String[] args) {
		int []data = {9, 3, 1, 100, 6, 2, 5};
		int idx = Arrays.binarySearch(data, 1);
		int idx2 = Arrays.binarySearch(data, 2);
		System.out.println(idx);
		System.out.println(idx2);
	}
}
