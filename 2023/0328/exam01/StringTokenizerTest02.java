package exam01;

import java.util.StringTokenizer;

public class StringTokenizerTest02 {
	public static void main(String[] args) {
		String data = "홍길동,이순신,김유신,유관순";
		String []arr = data.split(",");
		for(String name:arr) {
			System.out.println(name);
		}
		
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(data, ",");
		while(st.hasMoreTokens()) {
			String name = st.nextToken();
			System.out.println(name);
		}
	}
}
