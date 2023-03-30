package exam02;

import java.util.Scanner;

public class HarmonicMeanTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.println("first number: ");
		a = sc.nextInt();
		System.out.println("second number: ");
		b = sc.nextInt();
		if(a==-b) {
			System.out.println("Eror.Can\'t make Harmonic Mean");
			return;
		}
		double mean = 2*a*b/(a+b);
		System.out.println("Harmonic Mean = "+mean);
	}
}
