package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class Test01 extends JFrame {
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTextField jtf_name;
	
	public Test01() {
		jtf_name = new JTextField(10);
		colNames = new Vector<>();
		colNames.add("도서명");
		colNames.add("출판사명");
		colNames.add("구매가격");
		colNames.add("구매일자");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		
		JButton btn_search = new JButton("조회");
		JScrollPane jsp = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(new JLabel("고객명:"));
		p.add(jtf_name);
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
				String sql = "select bookname, publisher, saleprice, orderdate from orders o, customer c, book b "
						+"where o.bookid=b.bookid and o.custid=c.custid and name='"+jtf_name.getText()+"' order by orderdate desc";
				try {
					Connection conn = ConnectionProvider.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						Vector<String> v = new Vector<>();
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getInt(3)+"");
						v.add(rs.getDate(4)+"");
						rowData.add(v);
					}
					ConnectionProvider.close(rs, stmt, conn);
					table.updateUI();
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
	}
	public static void main(String[] args) {
		new Test01();
	}
}