package exam03;

public class Person extends Thread {
	private String name;
	private Account account;
	public Person(String name, Account account) {
		this.name = name;
		this.account = account;
	}
	public void run() {
		for(int i=1; i<=10;i++) {
			account.deposit(1000,i,name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}
