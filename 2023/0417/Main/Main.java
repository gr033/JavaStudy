package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String n = "cccCCC";
		System.out.println(solution(n));
	}
	static public String solution(String my_string) {
		 String answer = "";
	        for(int i=0;i<my_string.length();i++){
	            if(my_string.charAt(i)>='a' && my_string.charAt(i)<='z'){
	                answer += Character.toString(my_string.charAt(i)-32);
	            }else if(my_string.charAt(i)>='A' && my_string.charAt(i)<='Z'){
	                answer += Character.toString(my_string.charAt(i)+32);
	            }
	        }
	        return answer;
    }
}