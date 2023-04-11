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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentTestDelete_GUI extends JFrame{
	int row;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	JTable jta;
	JButton btn_delete;
	JTextField jtf;
	public StudentTestDelete_GUI() {
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colName.add("이름");
		colName.add("국어");
		colName.add("영어");
		colName.add("수학");
		jta = new JTable(rowData, colName);
		jtf = new JTextField(10);
		btn_delete = new JButton("삭제");
		JScrollPane jsp = new JScrollPane(jta);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(jsp);
		p2.add(new JLabel("이름입력:"));
		p2.add(jtf);
		p2.add(btn_delete);
		
		setLayout(new BorderLayout());
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		readStudent();
		
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name;
					System.out.println("이름 입력:");
					name = jtf.getText();
					String sql = "delete student where name='"+name+"'";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re > 0) {
						JOptionPane.showMessageDialog(null, "삭제하였습니다.");
						jta.updateUI();
					}else {
						JOptionPane.showMessageDialog(null, "실패");
					}
					conn.close();
					stmt.close();
					
				} catch (Exception e1) {
					System.out.println("예외발생:"+e1.getMessage());
				}
			}
		});
	}
	
	public void readStudent() {
		try {
			String sql = "select name,kor,eng,math from student";
			
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB서버에 연결한다.
			Connection conn 
			= DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"c##sist",
					"sist");
			
			//3. sql명령을 실행 Statement객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			//4. sql명령을 실행한다.
			ResultSet rs  = stmt.executeQuery(sql);
			
			while( rs.next()  ) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				int eng = rs.getInt(3);
				int math = rs.getInt(4);
				
				Vector<String> v = new Vector<String>();
				v.add(name);
				v.add(kor+"");
				v.add(eng+"");
				v.add(math+"");
				
				rowData.add(v);
			}
			
			jta.updateUI();
			
			//5. 사용했던 자원들을 닫아줍니다.
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		new StudentTestDelete_GUI();
	}
}