package com.sist.exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;
public class MainTest extends JFrame {
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTextField jtf_bookname;
	JTextField jtf_price;
	JTextField jtf_publisher;
	public MainTest() {
		colNames = new Vector<>();
		colNames.add("도서번호");
		colNames.add("도서명");
		colNames.add("가격");
		colNames.add("출판사");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		jtf_bookname = new JTextField(10);
		jtf_price = new JTextField(10);
		jtf_publisher = new JTextField(10);
		JButton btn_insert = new JButton("등록");
		JPanel p = new JPanel();
		p.add(new JLabel("도서명:"));
		p.add(jtf_bookname);
		p.add(new JLabel("가격:"));
		p.add(jtf_price);
		p.add(new JLabel("출판사:"));
		p.add(jtf_publisher);
		p.add(btn_insert);
		JScrollPane jsp = new JScrollPane(table);
		
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		loadData();
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookname = jtf_bookname.getText();
				int price = Integer.parseInt(jtf_price.getText());
				String publisher = jtf_publisher.getText();
				BookDAO dao = new BookDAO();
				BookVO b = new BookVO();
				b.setBookname(bookname);
				b.setPrice(price);
				b.setPublisher(publisher);
				int re = dao.insertBook(b);
				if(re>0) {
					JOptionPane.showMessageDialog(null, "등록하였습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.");
				}
				loadData();
			}
		});
	}
	//bookdao를 통해 도서목록을 DB로부터 불러와서 jtable에 출력하는 메소드를 정의
	public void loadData() {
		rowData.clear();
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = dao.listBook();
		for(BookVO b:list) {
			Vector<String> v = new Vector<>();
			v.add(b.getBookid()+"");
			v.add(b.getBookname());
			v.add(b.getPrice()+"");
			v.add(b.getPublisher());
			rowData.add(v);
		}
		table.updateUI();
	}
	public static void main(String[] args) {
		new MainTest();
	}
}
