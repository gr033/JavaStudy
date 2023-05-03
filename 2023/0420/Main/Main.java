package Main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []num_list = {12,4,15,46,38,1,14,56,32,10};
		

		String my_string = "banana";
		String is_suffix = "abanana";
		my_string=my_string.substring(my_string.length()-is_suffix.length());
		System.out.println(my_string);
		if(my_string.equals(is_suffix)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		
		
		System.out.println(solution(num_list));
	}
	static public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length-5];
        Arrays.sort(num_list);
        for(int i=5;i<num_list.length;i++) {
        	answer[i-5]=num_list[i];
        }
        return answer;
    }
}