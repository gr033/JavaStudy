package exam02;

public class StudentTest {

	public static void main(String[] args) {
		//학부생 객체를 생성
		UnderGraduate s = new UnderGraduate();
		s.setName("홍길동");
		s.setNo("2023031");
		s.setGrade(2);
		s.setCredit(3.8);
		s.setMajor("Computer Engineering");
		s.setClub("마라톤");
		System.out.println(s.toString());
		
		Graduate g = new Graduate();
		g.setCredit(4.0);
		g.setNo("202203");
		g.setGrade(3);
		g.setName("김유신");
		g.setMajor("Mechanical Engineering");
		g.setType("연구조교");
		g.setRate(0.5);
		System.out.println(g);
		
	}

}
