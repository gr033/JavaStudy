package exam10;

public class Car implements Movable {
	private String name;
	private String color;
	
	public void turnLeft() {
		System.out.println("좌회전합니다.");
	}
	
	public void turnRight() {
		System.out.println("우회전합니다.");
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	@Override
	public void speedUp(int amount) {
		System.out.println("속도를 증가합니다."+(speed+amount));
	}

	@Override
	public void speedDown(int amount) {
		System.out.println("속도를 감소합니다."+(speed+amount));
	}
}
