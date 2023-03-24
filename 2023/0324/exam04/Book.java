package exam04;

import java.util.Objects;

abstract public class Book {
	protected int number;
	protected String title;
	protected String author;
	public abstract int getLateFees(int days);
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		super();
	}
	
	public Book(int number, String title, String author) {
		super();
		this.number = number;
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [number=" + number + ", title=" + title + ", author=" + author + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return number == other.number;
	}
		
}
