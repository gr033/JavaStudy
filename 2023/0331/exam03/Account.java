package exam03;

public class Account {
	private int balance;
	public synchronized void deposit(int amount, int i, String name) {
		System.out.print(name+"의 "+i+"번째 모금");
		balance += amount;
		System.out.println("잔액: "+balance);
	}
	public int getBalance() {
		return balance;
	}
}
