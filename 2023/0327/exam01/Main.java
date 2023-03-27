package exam01;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String s = sc.next();
		 int[] n = new int[26];
		 for (int i = 0; i<n.length;i++) {
			 n[i] = -1;
		 }
		 for(int j=0;j<s.length();j++) {
			 if(n[s.charAt(j)-'a'] != -1) {
				 n[s.charAt(j)] = s.indexOf(j);
			 }
			 continue;
		 }
		 for(int i:n) {
			 System.out.print(i+" ");
		 }
		 sc.close();
	}
}