package exam04;

public class BankAccount {
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println(amount+"원 입금, 잔액: "+balance);
	}
	public void withdraw(int amount) throws NegativeBalanceException {
			if(amount>balance) {
				throw new NegativeBalanceException("잔액이 부족합니다.");
			}
		balance -= amount;
		System.out.println(amount+"원 출금, 잔액: "+balance);
	}
}
