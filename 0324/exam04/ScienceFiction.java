package exam04;

public class ScienceFiction extends Book {

	@Override
	public int getLateFees(int days) {
		return 600*days;
	}

	public ScienceFiction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScienceFiction(int number, String title, String author) {
		super(number, title, author);
		// TODO Auto-generated constructor stub
	}

}
