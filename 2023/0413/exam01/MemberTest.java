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

public class MemberTest extends JFrame{
	JTable table;
	JTextField jtf01;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	
	public MemberTest() {
		jtf01 = new JTextField(10);
		colName = new Vector<String>();
		colName.add("이름");
		colName.add("전화");
		colName.add("주소");
		colName.add("나이");
		
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		JButton btn_search = new JButton("검색");
		JPanel p = new JPanel();
		p.add(new JLabel("주소"));
		p.add(jtf01);
		p.add(btn_search);
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchMember();
			}
		});
	}
	
	public void searchMember() {
		String addr = jtf01.getText();
		String sql = "select * from member where addr='"+addr+"'";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rowData.clear();
			while(rs.next()) {
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String addr2 = rs.getString(3);
				int age = rs.getInt(4);
				
				Vector<String> v = new Vector<>();
				v.add(name);
				v.add(phone);
				v.add(addr2);
				v.add(age+"");
				rowData.add(v);
			}
			table.updateUI();
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new MemberTest();
	}
}
