package exam04;

public class Poet extends Book {

	@Override
	public int getLateFees(int days) {
		return 200*days;
	}

	public Poet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poet(int number, String title, String author) {
		super(number, title, author);
		// TODO Auto-generated constructor stub
	}

}
