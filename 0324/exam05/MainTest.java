package exam05;

public class MainTest {
	public static void printPrice(Buyable item) {
		System.out.printf("%10d\n", item.getPrice());
	}
	public static void main(String[] args) {
		Buyable b1 = new Television("S1234", "SAMSUNG", 2500000);
		Buyable b2 = new Refrigerator("L1000", "LG", 3000000);
		printPrice(b1);
		printPrice(b2);
	}

}
