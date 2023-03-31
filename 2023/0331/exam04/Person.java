package exam04;

public class Person extends Thread {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("안녕, "+name+": "+i);
		try {
			Thread.sleep(100);
		}catch(Exception e) {}
		}
	}
}
