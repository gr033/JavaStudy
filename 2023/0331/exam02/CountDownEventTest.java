package exam02;

public class CountDownEventTest {
	public static void main(String[] args) {
		CountDownEvent cde = new CountDownEvent(5000, "준비 완료");
		cde.start();
	}
}