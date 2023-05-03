package exam02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class BooklistTest extends JFrame {
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTable table;
	JTextField jtf_name;
	JTextField jtf_publisher;
	JTextField jtf_price;

	public BooklistTest() {
	colNames = new Vector<String>();
	colNames.add("도서번호");
	colNames.add("도서이름");
	colNames.add("출판사");
	colNames.add("가격");
	rowData = new Vector<Vector<String>>();
	table = new JTable(rowData, colNames);
	JScrollPane jsp = new JScrollPane(table);
	
	jtf_name = new JTextField(15);
	jtf_publisher = new JTextField(15);
	jtf_price = new JTextField(15);
	
	JButton btn_research = new JButton("조회");
	JButton btn_update = new JButton("추가");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	p1.add(new JLabel("도서이름"));
	p1.add(jtf_name);
	p1.add(new JLabel("출판사"));
	p1.add(jtf_publisher);
	p1.add(new JLabel("가격"));
	p1.add(jtf_price);
	
	p2.add(jsp);
	
	p3.add(btn_research);
	p3.add(btn_update);
	
	setLayout(new BorderLayout());
	add(p1, BorderLayout.NORTH);
	add(p2, BorderLayout.CENTER);
	add(p3, BorderLayout.SOUTH);
	
	setSize(1000,600);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//추가
	btn_update.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = jtf_name.getText();
			String publisher = jtf_publisher.getText();
			int price = Integer.parseInt(jtf_price.getText());
			BookDAO dao = new BookDAO();
			int re = dao.bookInsert(name, publisher, price);
			table.updateUI();
		}
	});
	//조회
	btn_research.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	}
	public static void main(String[] args) {
		new BooklistTest();
	}
}
