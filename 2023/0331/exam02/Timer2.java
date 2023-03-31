package exam02;

class Timer2 implements Runnable{
	public void run() {
		for(int i=20;i>=0;i--) {
			System.out.println(i+"초 전입니다.");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}	
	}
}