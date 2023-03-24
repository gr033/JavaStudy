package exam01;

public class Product {
	protected String name;
	protected int price;
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
}
