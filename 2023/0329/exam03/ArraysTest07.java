package exam03;

import java.util.Arrays;

public class ArraysTest07 {
	public static void main(String[] args) {
		int []data = {9, 1, 100, 3, 5, 7};
		String str = Arrays.toString(data);
		System.out.println(str);
		Arrays.sort(data);
		int max = data[data.length-1];
		System.out.println("최대값: "+max);
	}
}