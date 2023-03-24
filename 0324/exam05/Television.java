package exam05;

public class Television implements Buyable {
	private String model;
	private String maker;
	private int price;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Television(String model, String maker, int price) {
		super();
		this.model = model;
		this.maker = maker;
		this.price = price;
	}

	@Override
	public int getPrice() {
		return price;
	}

}
