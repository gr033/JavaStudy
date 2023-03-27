package exam01;

public class ValueOfTest {
	public static void pro(String data) {
		System.out.println("처리완료: "+data);
	}
	public static void main(String[] args) {
		int age = 20;
		boolean flag = true;
		double height = 178.9;
		pro(age+"");
		pro(flag+"");
		pro(height+"");
		
//		pro(String.valueOf(age));
//		pro(String.valueOf(flag));
//		pro(String.valueOf(height));
	}
}
