package com.exam.main;

import java.util.Scanner;

import com.exam.dao.BoardDAO;
import com.exam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title;
		String id;
		String content;
		System.out.println("글 제목: ");
		title = sc.next();
		System.out.println("작성자 id:");
		id = sc.next();
		sc.nextLine();
		System.out.println("글 내용: ");
		content = sc.nextLine();
		
		BoardVO b = new BoardVO(0, title, id, content, null, 0);
		BoardDAO dao = new BoardDAO();
		int re = dao.insertBoard(b);
		if(re==1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
}
