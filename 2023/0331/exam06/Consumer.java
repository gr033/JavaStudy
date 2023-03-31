package exam06;

public class Consumer extends Thread {
	private Product product;
	public Consumer(Product product) {
		this.product = product;
	}
	public void run() {
		for(int i=1;i<=10;i++) {
			product.useNumber();
			try {
				Thread.sleep(100);
			} catch (Exception e) {	}
		}
	}
}
