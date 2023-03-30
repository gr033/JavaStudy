package exam02;

import java.util.Scanner;

class NotFoundHarmonicMeanException extends Exception{
	public NotFoundHarmonicMeanException(String msg) {
		super(msg);
	}
}

public class HarmonicMeanTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		try {
			System.out.println("first number: ");
			a = sc.nextInt();
			System.out.println("second number: ");
			b = sc.nextInt();
			if(a==-b) {
				throw new NotFoundHarmonicMeanException("Can\'t make Harmonic Mean");
			}
			double mean = 2*a*b/(a+b);
			System.out.println("Harmonic Mean = "+mean);
		}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
				return;
		}
	}
}
