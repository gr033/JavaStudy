package exam04;

public class Graduate extends Student{
	private double rate;
	private String type;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Graduate(String name, String no, String major, int grade, double credit, double rate, String type) {
		super(name, no, major, grade, credit);
		this.rate = rate;
		this.type = type;
	}
	public Graduate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Graduate [rate=" + rate + ", type=" + type + ", name=" + name + ", no=" + no + ", major=" + major
				+ ", grade=" + grade + ", credit=" + credit + "]";
	}
	
}
