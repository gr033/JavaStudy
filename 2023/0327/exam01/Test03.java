package exam01;

public class Test03 {
	public static void main(String[] args) {
		String []data = {"kim", "tiger", "hong", "Tiger", "  tiger", "lee", "TIGER  "};
		//배열 안에 타이거는 모두 몇 명 있는지 파악, 대소문자 구별없이 판별, 데이터 앞에 공백도 제거
		int cnt = 0;
		for (int i =0;i<data.length;i++){
			 String temp = data[i].toLowerCase();
			 temp = temp.trim();
			 if(temp.equals("tiger")){
			 	cnt++;
			 }
		  }
		System.out.println(cnt);
		System.out.println();
		for (int i = 0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
}
/*	
 int cnt = 0;
 for (int i =0;i<data.length;i++) {
			data[i] = data[i].toLowerCase();
			data[i] = data[i].trim();
			if(data[i].equals(data0)) {cnt++;}
			}

 */