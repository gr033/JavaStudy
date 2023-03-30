package exam04;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		try {
			ba.deposit(10000);
			ba.deposit(15000);
			ba.withdraw(15000);
			ba.withdraw(30000);
		}catch(Exception e) {
			System.out.println("에러발생: "+e.getMessage());
		}finally {System.out.println("잔액: "+ba.getBalance());}
	}
}
