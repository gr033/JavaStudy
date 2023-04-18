package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookTest extends JFrame {
	JButton btn_search;
	JTextField jtf_name;
	JTable table_non;
	JTable table_on;
	JLabel jlb_result;
	Vector<String> colNames_non;
	Vector<Vector<String>> rowData_non;
	Vector<String> colNames_on;
	Vector<Vector<String>> rowData_on;
	
	public BookTest() {
		colNames_non = new Vector<String>();
		colNames_on = new Vector<String>();
		
		colNames_non.add("도서번호");
		colNames_non.add("도서명");
		colNames_non.add("정가");
		colNames_non.add("판매가격");
		
		colNames_on.add("도서번호");
		colNames_on.add("도서명");
		colNames_on.add("정가");
		colNames_on.add("판매가격");
		
		rowData_non = new Vector<Vector<String>>();
		rowData_on = new Vector<Vector<String>>();
		table_non = new JTable(rowData_non, colNames_non);
		table_on = new JTable(rowData_on, colNames_on);
		
		btn_search = new JButton("입력");
		jtf_name = new JTextField(10);
		jlb_result = new JLabel();
		
		JPanel p_label = new JPanel(new GridLayout(1, 2));
		p_label.add(new JLabel("구매하지 않은 도서"));
		p_label.add(new JLabel("구매 도서"));
		
		JPanel p_search = new JPanel();
		p_search.add(new JLabel("이름"));
		p_search.add(jtf_name);
		p_search.add(btn_search);
		
		JPanel p_name = new JPanel(new GridLayout(2, 1));
		p_name.add(p_search);
		p_name.add(p_label);
		
		JScrollPane jsp_non = new JScrollPane(table_non);
		JScrollPane jsp_on = new JScrollPane(table_on);

		JPanel p_book = new JPanel(new GridLayout(1, 2));
		p_book.add(jsp_non);
		p_book.add(jsp_on);
		
		JPanel p_result = new JPanel();
		p_result.add(new JLabel("총 구매금액"));
		p_result.add(jlb_result);
		
		setLayout(new BorderLayout());
		add(p_name, BorderLayout.NORTH);
		add(p_book, BorderLayout.CENTER);
		add(p_result, BorderLayout.SOUTH);
		setSize(1000,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_search.addActionListener(new ActionListener() {
			String name = jtf_name.getText();
			BookDAO dao = new BookDAO();
			ArrayList<BookVO> list = dao.findBuyBook(name);
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public static void main(String[] args) {
		new BookTest();
	}
}
