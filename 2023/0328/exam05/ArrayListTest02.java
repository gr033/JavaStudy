package exam05;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	public static void printAll(ArrayList<Student> list) {
		for(int i=0;i<list.size();i++) {
			Student data = list.get(i);
			System.out.println("이름: "+data.getName());
			System.out.println("주소: "+data.getAddr());
			System.out.println("전화번호: "+data.getPhone());
			System.out.println();
		}
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
			System.out.println("메뉴를 선택하세요: ");
			System.out.println("0. 종료");
			sel = sc.nextInt();
			if(sel==0) {
				break;
			}
			insertStudent(list);
		}
		printAll(list);
	}
}
