package exam02;

public class UnderGraduate extends Student{
	private String club;

	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public UnderGraduate(String name, String no, String major, int grade, double credit, String club) {
		super(name, no, major, grade, credit);
		this.club = club;
	}
	public UnderGraduate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UnderGraduate [club=" + club + ", name=" + name + ", no=" + no + ", major=" + major + ", grade=" + grade
				+ ", credit=" + credit + "]";
	}

	
}
