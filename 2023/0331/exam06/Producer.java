package exam06;

public class Producer extends Thread {
	private Product product;
	
	public Producer(Product product) {
		this.product = product;
	}
	public void run() {
		for(int i=1;i<=10;i++) {
			product.makeNumber();
			try {
				Thread.sleep(100);
			} catch (Exception e) {	}
		}
	}
}
