package exam01;

public class DiscountProduct extends Product{
	private double discount;

	public DiscountProduct(String name, int price, double discount) {
		super(name, price);
		this.discount = discount;
	}

	public DiscountProduct() {
		super();
	}

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

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return (int)(price*(1-discount));
	}
	
}
