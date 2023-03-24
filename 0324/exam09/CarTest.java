package exam09;

public class CarTest {

	public static void main(String[] args) {
//		Vehicle v = new Vehicle();
//		추상클래스의 객체는 생성할 수 없음
		Car myCar = new Car();
		System.out.println(myCar.getKilosPerLiter());
		myCar.printSpeed();
	}

}
