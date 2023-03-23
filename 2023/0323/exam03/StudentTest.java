/*상속관계에 있을 때에 부모 클래스의 참조 변수가 자식 클래스의 객체를 생성할
 * 수 있음 그러나 자식 클래스에서 추가된 멤버에는 접근 불가능
 * 접근하려면 해당 자식 클래스로 자료형 변환하여 접근해야함*/
package exam03;

public class StudentTest {

	public static void main(String[] args) {
		//학부생 객체를 생성
		Student s = new UnderGraduate();
		s.setName("홍길동");
		s.setNo("2023031");
		s.setGrade(2);
		s.setCredit(3.8);
		s.setMajor("Computer Engineering");
		s.setClub("마라톤");
		System.out.println(s.toString());
		
		Student g = new Graduate();
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
