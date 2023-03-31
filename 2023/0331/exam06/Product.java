package exam06;

import java.util.Random;

public class Product {
	private int num;
	private boolean isNew;
	
	public synchronized void useNumber() {
		while(isNew == false) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("소비자가 제품을 소비: "+num);
		isNew = false;
		notify();
	}
	public synchronized void makeNumber() {
		Random r = new Random();
		while(isNew == true) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		num = r.nextInt(100)+1;
		System.out.println("생산자가 새로운 제품 생산: "+num);
		isNew = true;
		notify();
	}
}