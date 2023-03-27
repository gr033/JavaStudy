package exam01;

public class EqualsTest {
	public static void main(String[] args) {
		String data1 = new String("hello");
		String data2 = new String("hello");
		if(data1.equals(data2)) {
			System.out.println("same");
		}
		else {System.out.println("different");}
//		if(data1==data2) {
//			System.out.println("같아요");
//		}
//		else {
//			System.out.println("달라요");
//		}
	}

}
