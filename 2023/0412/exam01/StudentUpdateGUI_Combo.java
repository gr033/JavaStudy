package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentUpdateGUI_Combo extends JFrame {
	JComboBox<String> jcb_name;
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
	public StudentUpdateGUI_Combo() {
		jcb_name = new JComboBox<String>();
		JButton btn = new JButton("수정");
		JLabel jlb_name = new JLabel("수정할 학생의 이름:");
		JLabel jlb_kor = new JLabel("국어:");
		JLabel jlb_eng = new JLabel("영어");
		JLabel jlb_math = new JLabel("수학:");
		jtf_name = new JTextField(10);
		jtf_kor = new JTextField(10);
		jtf_eng = new JTextField(10);
		jtf_math = new JTextField(10);
		
		loadName();
		
		setLayout(new FlowLayout());
		
		add(jlb_name);
		add(jcb_name);
		add(jlb_kor);
		add(jtf_kor);
		add(jlb_eng);
		add(jtf_eng);
		add(jlb_math);
		add(jtf_math);
		add(btn);
		setSize(800,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jcb_name.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String []subject = {"kor", "eng", "math"};
					String name = (String)jcb_name.getSelectedItem();
					
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "c##sist";
					String pwd = "sist";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url, user, pwd);
					Statement stmt = conn.createStatement();
						String sql = "select kor,eng,math from student where name='"+name+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							int kor = rs.getInt(1);
							int eng = rs.getInt(2);
							int math = rs.getInt(3);
							jtf_kor.setText(kor+"");
							jtf_eng.setText(eng+"");
							jtf_math.setText(math+"");
						}
						rs.close();
						conn.close();
						stmt.close();
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = (String) jcb_name.getSelectedItem();
					int kor = Integer.parseInt(jtf_kor.getText());
					int eng = Integer.parseInt(jtf_eng.getText());
					int math = Integer.parseInt(jtf_math.getText());
					String sql = "update student set kor="+kor+",eng="+eng+",math="+math+" where name ='"+name+"'";
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "c##sist";
					String pwd = "sist";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(url, user, pwd);
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re>0) {
						JOptionPane.showMessageDialog(null, "수정하였습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "실패");
					}
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
	}
	//데이터베이스 연결하여 모든 학생의 이름을 조회하여 콤보박스에 추가하는 메소드 정의
	public void loadName() {
		String sql = "select name from student";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##sist";
			String pwd = "sist";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String name = rs.getString(1);
				jcb_name.addItem(name);
			}
			rs.close();
			conn.close();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new StudentUpdateGUI_Combo();
	}
}