package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentUpdateGUI extends JFrame {
	
	public StudentUpdateGUI() {
		JButton btn = new JButton("수정");
		JLabel jlb_name = new JLabel("수정할 학생의 이름:");
		JLabel jlb_kor = new JLabel("국어:");
		JLabel jlb_eng = new JLabel("영어");
		JLabel jlb_math = new JLabel("수학:");
		JTextField jtf_name = new JTextField(5);
		JTextField jtf_kor = new JTextField(5);
		JTextField jtf_eng = new JTextField(5);
		JTextField jtf_math = new JTextField(5);
		
		setLayout(new FlowLayout());
		
		add(jlb_name);
		add(jtf_name);
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
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = jtf_name.getText();
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
	public static void main(String[] args) {
		new StudentUpdateGUI();
	}
}