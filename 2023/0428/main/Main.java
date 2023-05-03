package main;

public class Main {

	public static void main(String[] args) {
		String myString = "ABBAA";
		String[] strArr = {"AAA","BBB","CCC","DDD"};
		String pet = "AABB";
		System.out.println(solution(strArr));
	}
	static  public String[] solution(String strArr[]) {
		 String[] answer = new String[strArr.length];
	        for(int i=0;i<answer.length;i++){
	            if(i%2==1){
	                answer[i] = strArr[i].toLowerCase();
	            }else{
	                answer[i] = strArr[i].toUpperCase();
	            }
	        }
	        return answer;
	    }
	}