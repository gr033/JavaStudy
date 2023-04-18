package exam01;

public class BookVO {
	private int bookid;
	private String bookname;
	private int price;
	private int saleprice;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public BookVO(int bookid, String bookname, int price, int saleprice) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.saleprice = saleprice;
	}
}
