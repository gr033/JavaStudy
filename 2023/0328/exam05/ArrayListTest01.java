package exam05;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest01 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
//		list.add(new Student("홍길동", "서울", "1111"));
//		list.add(new Student("이순신", "광주", "2222"));
//		list.add(new Student("김유신", "대전", "3333"));
		Scanner sc = new Scanner(System.in);
		String name;
		String addr;
		String phone;
		int sel;
		while(true) {
			System.out.println("메뉴를 선택하세요: ");
			System.out.println("0. 종료");
			sel = sc.nextInt();
			if(sel==0) {
				break;
			}
			System.out.println("추가할 학생의 이름: ");
			name = sc.next();
			System.out.println("추가할 학생의 주소: ");
			addr = sc.next();
			System.out.println("추가할 학생의 전화번호: ");
			phone = sc.next();
			list.add(new Student(name, addr, phone));
		}
		
			
		for(int i=0;i<list.size();i++) {
			Student data = list.get(i);
			System.out.println("이름: "+data.getName());
			System.out.println("주소: "+data.getAddr());
			System.out.println("전화번호: "+data.getPhone());
			System.out.println();
		}
		
//		ArrayList<String> list1 = new ArrayList<String>();
//		list1.add("홍길동");
//		list1.add("이순신");
//		list1.add("유관순");
//		for(int i=0;i<list1.size();i++) {
//			String data = list1.get(i);
//			System.out.println(data);
//		}
	}
}
