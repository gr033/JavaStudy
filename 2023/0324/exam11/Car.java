package exam11;

public class Car extends Vehicle implements Movable {
	private String name;
	private String color;
	
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
		System.out.println("속도를 증가합니다. "+(speed+amount));
	}

	@Override
	public void speedDown(int amount) {
		System.out.println("속도를 감소합니다. "+(speed+amount));
	}

	@Override
	public double getKilosPerLiter() {
		return 5;
	}

}
