package exam01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import db.ConnectionProvider;

public class Test01 extends JFrame {
	JTable table;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	
	public Test01() {
		colNames = new Vector<String>();
		colNames.add("고객번호");
		colNames.add("총 주문건수");
		colNames.add("총 주문금액");
		colNames.add("평균 주문금액");
		colNames.add("최고 주문금액");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadData();
	}
	public void loadData() {
		String sql = "select custid,count(*),sum(saleprice),avg(saleprice),max(saleprice) from orders group by custid";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custid = rs.getInt(1);
				int count = rs.getInt(2);
				int sum = rs.getInt(3);
				double avg = rs.getDouble(4);
				int max = rs.getInt(5);
				Vector<String> v = new Vector<>();
				v.add(custid+"");
				v.add(count+"");
				v.add(sum+"");
				v.add(max+"");
				v.add(avg+"");
				rowData.add(v);
			}
			table.updateUI();
			ConnectionProvider.close(rs,stmt,conn);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Test01();
	}
}