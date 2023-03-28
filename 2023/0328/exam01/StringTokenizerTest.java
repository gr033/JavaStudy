package exam01;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String data = "hello Korea hello Java";
		StringTokenizer st = new StringTokenizer(data);
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			System.out.println(str);
		}
	}
}
