package exam10;

public class DiscountProduct extends Product {
	private double discount;
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "DiscountProduct [discount=" + discount + ", name=" + name + ", price=" + price + "]";
	}

	public DiscountProduct(String name, double price, double discount) {
		super(name, price);
		this.discount = discount;
	}
	public double getPrice() {
		return price*(1-discount/100);
	}
}