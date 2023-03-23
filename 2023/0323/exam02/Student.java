package exam02;

public class Student {
	protected String name;
	protected String no;
	protected String major;
	protected int grade;
	protected double credit;
	public String getName() {
		return name;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String no, String major, int grade, double credit) {
		super();
		this.name = name;
		this.no = no;
		this.major = major;
		this.grade = grade;
		this.credit = credit;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", no=" + no + ", major=" + major + ", grade=" + grade + ", credit=" + credit
				+ "]";
	}
	
	
}
