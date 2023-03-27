package exam01;

public class Test05 {
	public static void main(String[] args) {
		String []data = {"kim", "tiger", "hong", "Tiger", "  tiger", "lee", "TIGER  "};
		//배열 안에 타이거는 모두 몇 명 있는지 파악, 대소문자 구별없이 판별, 데이터 앞에 공백도 제거
		int cnt = 0;
		for(String name:data) {
			if(name.trim().equalsIgnoreCase("tiger")) {cnt++;}
		}
		System.out.println(cnt);
	}
}