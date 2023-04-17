package exam03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.OrdersDAO;

public class Test01 extends JFrame {
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTextField jtf_publisher;
	
	public Test01() {
		jtf_publisher = new JTextField(10);
		colNames = new Vector<>();
		colNames.add("고객명");
		colNames.add("주소");
		colNames.add("전화");
		colNames.add("도서명");
		colNames.add("도서가격");
		colNames.add("판매가격");
		colNames.add("금액차이");
		colNames.add("주문일");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		
		JButton btn_search = new JButton("조회");
		JScrollPane jsp = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(new JLabel("출판사명:"));
		p.add(jtf_publisher);
		p.add(btn_search);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rowData.clear();
				String publisher = jtf_publisher.getText();
				OrdersDAO dao = new OrdersDAO();
				ArrayList<HashMap<String, Object>> list = dao.findAllByPublisher(publisher);
				for(HashMap<String, Object> map : list) {
					Vector<String> v = new Vector<>();
					v.add((String)map.get("name"));
					v.add((String)map.get("address"));
					v.add((String)map.get("phone"));
					v.add((String)map.get("bookname"));
					v.add((Integer)map.get("price")+"");
					v.add((Integer)map.get("saleprice")+"");
					v.add((Integer)map.get("price_sale")+"");
					v.add((Date)map.get("orderdate")+"");
					rowData.add(v);
				}
				table.updateUI();
			}
		});
	}
	public static void main(String[] args) {
		new Test01();
	}
}