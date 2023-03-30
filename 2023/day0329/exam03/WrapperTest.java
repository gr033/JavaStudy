package exam03;

import java.util.ArrayList;

/*
 기본자료형으로 객체를 만들어주는 클래스 ->Wrapper Class
 boolean	->Boolean
 character	->Character
 byte 		->Byte
 short		->Short
 int		->Integer
 long 		->Long
 float 		->Float
 double 	->Double
 */
public class WrapperTest {
	public static void main(String[] args) {
//		ArrayList<int> list = new Arraylist<int>();
//		자바의 컬렉션프레임웤은 기본자료형은 상대하지 않고
//		객체를 상대
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(100));
		list.add(100);	//auto Boxing
		
	}
}
