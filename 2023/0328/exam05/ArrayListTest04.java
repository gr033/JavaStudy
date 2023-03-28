package exam05;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void searchStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String phone;
		System.out.println("검색하려는 학생의 전화번호: ");
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
			System.out.println("학생 확인");
			System.out.println("이름: "+st.getName());
			System.out.println("주소: "+st.getAddr());
			System.out.println("전화번호: "+st.getPhone());
			System.out.println();
		}
		else {
			System.out.println("해당 전화번호의 학생을 찾지 못했습니다.");
		}
	}
	public static void deleteStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 학생의 전화번호를 입력하세요: ");
		String phone = sc.next();
		int i = 0;
		int size = list.size();
		for(i=0;i<list.size();i++) {
			Student s = list.get(i);
			if(s.getPhone().equals(phone)) {
				list.remove(i);
			}
		}
		if(i<size) {
			System.out.println("해당 학생의 정보를 삭제했습니다.");
		}else {System.out.println("해당 학생의 정보가 없습니다.");}
		System.out.println();
	}
	public static void printAll(ArrayList<Student> list) {
		for(int i=0;i<list.size();i++) {
			Student data = list.get(i);
			System.out.println("이름: "+data.getName());
			System.out.println("주소: "+data.getAddr());
			System.out.println("전화번호: "+data.getPhone());
			System.out.println();
		}
	}
	public static void menu() {
		System.out.println("메뉴를 선택하세요: ");
		System.out.println("1.학생추가  2.검색  3.삭제  4.  모두출력  0. 종료");
	}
	public static void insertStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String name;
		String addr;
		String phone;
		System.out.println("추가할 학생의 이름: ");
		name = sc.next();
		System.out.println("추가할 학생의 주소: ");
		addr = sc.next();
		System.out.println("추가할 학생의 전화번호: ");
		phone = sc.next();
		list.add(new Student(name, addr, phone));
	}
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int sel;
		while(true) {
			menu();
			sel = sc.nextInt();
			if(sel==0) {
				break;
			}
			switch (sel) {
			case 1:insertStudent(list); break;
			case 2:searchStudent(list); break;
			case 3:deleteStudent(list); break;
			case 4:printAll(list);break;			
			}
		}
		System.out.println("프로그램 종료");
	}
}
