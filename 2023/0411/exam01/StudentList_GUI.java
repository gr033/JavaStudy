package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StudentList_GUI extends JFrame{
	JTextArea jta;
	JButton btn;
	public StudentList_GUI() {
		jta = new JTextArea();
		JScrollPane js = new JScrollPane(jta);
		btn = new JButton("출력");
		setLayout(new BorderLayout());
		add(js, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "c##sist";
					String pwd = "sist";
					String sql = "select name from student";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url, user, pwd);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String name = rs.getString(1);
						jta.append(name+"\n");
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e1) {
					System.out.println("예외발생:"+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		new StudentList_GUI();
	}
}