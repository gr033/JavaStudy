package exam02;

class Timer1 extends Thread {
	public void run() {
		for(int i=20;i>=1;i--) {
			System.out.println(i+"초 전입니다.");
			if(i==18) {
				System.out.println("연결장치 분리");
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}	
		System.out.println("발사");
	}
}