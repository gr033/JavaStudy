package exam04;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
	private String name;
	private String addr;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
}
public class Programming08 {
	public static void inputStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String name, addr, phone;
		System.out.print("추가할 학생의 이름: ");
		name = sc.next();
		System.out.print("추가할 학생의 주소: ");
		addr = sc.next();
		System.out.print("추가할 학생의 핸드폰 번호: ");
		phone = sc.next();
		Student st = new Student(name, addr, phone);
		list.add(st);
	}
	public static void searchStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String phone;
		System.out.print("검색할 학생의 전화번호: ");
		phone = sc.next();
		Student st = null;
		for(int i=0;i<list.size();i++) {
			Student s = list.get(i);
			if(s.getPhone().equals(phone)) {
				st = s;
				break;
			}
		}
		if(st != null) {
			System.out.println("검색하시는 학생의 정보");
			System.out.println("이름: "+st.getName());
			System.out.println("주소: "+st.getAddr());
			System.out.println("전화번호: "+st.getPhone());
		}
		else {
			System.out.println("검색하려는 학생의 정보가 없습니다.");
		}
	}
	public static void deleteStudent(ArrayList<Student> list) {
		
	}
	public static void printAll(ArrayList<Student> list) {
		for(Student st:list) {
			System.out.println(st);
		}
	}
	public static void menu() {
		System.out.println("1.추가 2.검색 3.삭제 4.모두출력 0.종료");
		System.out.println("선택하세요");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		int sel;
		while(true) {
			menu();
			sel = sc.nextInt();
			if(sel==0) {
				System.out.println("프로그램 종료");
				break;
			}
			switch(sel) {
			case 1: inputStudent(list);break;
			case 2: searchStudent(list);break;
			case 3: deleteStudent(list);break;
			case 4: printAll(list);break;
			}
		}
	}
}
