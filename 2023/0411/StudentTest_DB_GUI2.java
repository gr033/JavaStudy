//학생의 이름, 국어, 영어, 수학 점수를 입력받아 출력하는 프로그램
package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentTest_DB_GUI2 extends JFrame {
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
	
	public StudentTest_DB_GUI2() {
		jtf_name = new JTextField(10);
		jtf_kor = new JTextField(10);
		jtf_eng = new JTextField(10);
		jtf_math = new JTextField(10);
		
		setLayout(new FlowLayout());
		add(new JLabel("이름"));
		add(jtf_name);
		add(new JLabel("국어"));
		add(jtf_kor);
		add(new JLabel("영어"));
		add(jtf_eng);
		add(new JLabel("수학"));
		add(jtf_math);
		
		JButton btn_add = new JButton("등록");
		add(btn_add);
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText();
				int kor = Integer.parseInt(jtf_kor.getText());
				int eng = Integer.parseInt(jtf_eng.getText());
				int math = Integer.parseInt(jtf_math.getText());
				String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+")";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re==1) {
						JOptionPane.showMessageDialog(null, "레코드를 추가하였습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "레코드 추가에 실패했습니다.");
					}
					stmt.close();
					conn.close();
					
					jtf_name.setText("");
					jtf_kor.setText("");
					jtf_eng.setText("");
					jtf_math.setText("");
				} catch (Exception e2) {
					System.out.println("예외발생"+e2.getMessage());
				}
			}
		});
	}
	public static void main(String[] args) {
		new StudentTest_DB_GUI2();
	}
}