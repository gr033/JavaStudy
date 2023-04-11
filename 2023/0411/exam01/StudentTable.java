package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentTable extends JFrame {
	int row;
	JTable jt;
	JButton btn;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	public StudentTable() {
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		btn = new JButton("조회");
		colName.add("이름");
		colName.add("국어");
		colName.add("영어");
		colName.add("수학");
		colName.add("총점");
		colName.add("평균");
		
		JPanel p = new JPanel();
		jt = new JTable(rowData, colName);
		JScrollPane js = new JScrollPane(jt);
		
		setLayout(new BorderLayout());
		
		p.add(js);
		add(p, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "c##sist";
					String pwd = "sist";
					String sql = "select name,kor,eng,math from student";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url, user, pwd);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						Vector<String> row = new Vector<String>();
						String name = rs.getString(1);
						int kor = rs.getInt(2);
						int eng = rs.getInt(3);
						int math = rs.getInt(4);
						int sum = kor+eng+math;
						double avg = (double) sum/3;
						row.add(name);
						row.add(kor+"");
						row.add(eng+"");
						row.add(math+"");
						row.add(sum+"");
						row.add(avg+"");
						rowData.add(row);
						jt.updateUI();
					}
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
	}
	public static void main(String[] args) {
		new StudentTable();
	}
}
