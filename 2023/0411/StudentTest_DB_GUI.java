//학생의 이름, 국어, 영어, 수학 점수를 입력받아 출력하는 프로그램
package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentTest_DB_GUI extends JFrame{
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
	JButton btn_add;
	
	public StudentTest_DB_GUI() {
		JLabel jlb_name = new JLabel("이름:");
		JLabel jlb_kor = new JLabel("국어:");
		JLabel jlb_eng = new JLabel("영어:");
		JLabel jlb_math = new JLabel("수학:");
		jtf_name = new JTextField(10);
		jtf_kor = new JTextField(10);
		jtf_eng = new JTextField(10);
		jtf_math = new JTextField(10);
		btn_add = new JButton("추가");
		
		JPanel p = new JPanel(new GridLayout(4,2));
		p.add(jlb_name);
		p.add(jtf_name);
		p.add(jlb_kor);
		p.add(jtf_kor);
		p.add(jlb_eng);
		p.add(jtf_eng);
		p.add(jlb_math);
		p.add(jtf_math);
		
		setLayout(new BorderLayout());
		
		add(p, BorderLayout.CENTER);
		add(btn_add, BorderLayout.SOUTH);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText();
				int kor = Integer.parseInt(jtf_kor.getText());
				int eng = Integer.parseInt(jtf_eng.getText());
				int math = Integer.parseInt(jtf_math.getText());
				saveData(name, kor, eng, math);
			}
		});
	}
	public void saveData(String name, int kor, int eng, int math) {
		try {
			String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+")";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re == 1) {
				JOptionPane.showMessageDialog(null, "레코드를 추가하였습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "실패");
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new StudentTest_DB_GUI();
	}
}
