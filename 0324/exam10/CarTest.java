package exam10;

public class CarTest {
	public static void main(String[] args) {
//		Car car = new Car("람보르기니", "Grey");
//		car.speedUp(200);
//		car.speedDown(100);
//		System.out.println(car);
		Movable m = new Car("람보르기니", "Grey");
		m.speedUp(200);
		m.speedDown(100);
//		movable과 car는 상속관계에 있기 때문에 
//		movable의 참조변수가 car객체를 참조할 수 있다.
//		speedUp은 원래부터 Movable에 있는 메소드이기 때문에 호출 가능
// 		car에서 오버라이딩한 speedUp이 동작한다.
		((Car)m).turnLeft();
//		부모의 참조변수가 자식클래스의 객체를 참조할 수 있지만
// 		자식클래스에서 추가된 멤버에 접근할 수 없음
// 		접근하려면 해당 자식클래스로 형변환하여 접근해야한다.
	}

}
