package exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class Programming07 {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		double temp;
		for(int i=1;i<=10;i++) {
			System.out.print(i+"번째 심사위원 점수: ");
			temp = sc.nextDouble();
			list.add(temp);
		}
		System.out.println();
		System.out.println(list);
		double max = list.get(0);
		int idx_max = 0;
		double min = list.get(0);
		int idx_min = 0;
		for(int i=1;i>list.size();i++) {
			if(list.get(i)>max){
				max = list.get(i);
				idx_max = i;
			}
			if(list.get(i)<min) {
				min = list.get(i);
				idx_min = i;
			}
		}
		double sum = 0;
		for(int i = 0;i<list.size();i++) {
			if(i != idx_min && i!=idx_max) {
				sum += list.get(i);
			}
		}
		System.out.println("집계점수: "+sum);
	}
}
