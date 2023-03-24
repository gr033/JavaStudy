package exam04;

public class Novel extends Book {
	
	@Override
	public int getLateFees(int days) {
		return 300*days;
	}

	public Novel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Novel(int number, String title, String author) {
		super(number, title, author);
		// TODO Auto-generated constructor stub
	}

}
