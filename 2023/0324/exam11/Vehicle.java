package exam11;

public abstract class Vehicle {
	private int speed;
	public abstract double getKilosPerLiter();	
	public void printSpeed() {
		System.out.println("현재속도: "+speed);
	}
	public Vehicle() {
		super();
	}
	
	public Vehicle(int speed) {
		super();
		this.speed = speed;
	}


	@Override
	public String toString() {
		return "Vehicle [speed=" + speed + "]";
	}
}
