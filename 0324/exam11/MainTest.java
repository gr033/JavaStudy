package exam11;

public class MainTest {
	public static void main(String[] args) {
		Car myCar = new Car("람보르기니", "Grey");
		System.out.println(myCar.getKilosPerLiter());
		myCar.speedUp(200);
		myCar.speedDown(100);
	}
}