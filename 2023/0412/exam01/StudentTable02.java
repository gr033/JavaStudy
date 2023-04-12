package exam01;
//데이터베이스 연결하여 모든 학생의 이름,국어,영어,수학을
//JTable에 출력하도록 합니다.

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class StudentTable02 extends JFrame {
	JTable table;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	int row;
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
	JButton btn_add;
	JButton btn_update;
	JButton btn_delete;
	public StudentTable02() {
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("국어");
		colNames.add("영어");
		colNames.add("수학");
		rowData = new Vector<Vector<String>>();
		
		jtf_name = new JTextField(10);
		jtf_kor = new JTextField(10);
		jtf_eng = new JTextField(10);
		jtf_math = new JTextField(10);
		btn_add = new JButton("등록");
		btn_update= new JButton("수정");
		btn_delete = new JButton("삭제");
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		p.add(new JLabel("이름:"));
		p.add(jtf_name);
		p.add(new JLabel("국어:"));
		p.add(jtf_kor);
		p.add(new JLabel("영어:"));
		p.add(jtf_eng);
		p.add(new JLabel("수학:"));
		p.add(jtf_math);
		
		p2.add(btn_add);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		setLayout(new GridLayout(3,1));
		add(jsp);
		add(p);
		add(p2);
		
		readStudent();		
		
		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Vector<String> row = new Vector<String>();
					String name = jtf_name.getText();
					int kor = Integer.parseInt(jtf_kor.getText());
					int eng = Integer.parseInt(jtf_eng.getText());
					int math = Integer.parseInt(jtf_math.getText());
					row.add(name);
					row.add(kor+"");
					row.add(eng+"");
					row.add(math+"");
					String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+")";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re>0) {
						JOptionPane.showMessageDialog(null, "추가하였습니다.");
					}else {
						System.out.println("추가 실패했습니다.");
					}
					conn.close();
					stmt.close();
					jtf_name.setText("");
					jtf_kor.setText("");
					jtf_eng.setText("");
					jtf_math.setText("");
					rowData.add(row);
					table.updateUI();
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = new Vector<String>();
				String name = jtf_name.getText();
				int kor = Integer.parseInt(jtf_kor.getText());
				int eng = Integer.parseInt(jtf_eng.getText());
				int math = Integer.parseInt(jtf_math.getText());
				v.add(name);
				v.add(kor+"");
				v.add(eng+"");
				v.add(math+"");
				rowData.set(row, v);
				try {
					String sql = "update student set kor="+kor+",eng="+eng+",math="+math+" where name='"+name+"'";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist","sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re>0) {
						JOptionPane.showMessageDialog(null, "수정하였습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "수정 실패했습니다.");
					}
					conn.close();
					stmt.close();
					table.updateUI();
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = new Vector<String>();
				String name = jtf_name.getText();
				int kor = Integer.parseInt(jtf_kor.getText());
				int eng = Integer.parseInt(jtf_eng.getText());
				int math = Integer.parseInt(jtf_math.getText());
				int ra = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
				if(ra != 0) {
					return;
				}
				rowData.remove(row);
				table.updateUI();
				try {
					String sql = "delete student where name='"+name+"'";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist","sist");
					Statement stmt = conn.createStatement();
					int re = stmt.executeUpdate(sql);
					if(re>0) {
						JOptionPane.showMessageDialog(null, "삭제하였습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "삭제 실패했습니다.");
					}
					conn.close();
					stmt.close();
				} catch (Exception e2) {
					System.out.println("예외발생:"+e2.getMessage());
				}
			}
		});
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				Vector<String> v = rowData.get(row);
				jtf_name.setText(v.get(0));
				jtf_kor.setText(v.get(1));
				jtf_eng.setText(v.get(2));
				jtf_math.setText(v.get(3));
			}
		});
	}
	public void readStudent() {
		try {
			String sql = "select name,kor,eng,math from student";
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB서버에 연결한다.
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
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
			table.updateUI();
			//5. 사용했던 자원들을 닫아줍니다.
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new StudentTable02();
	}
}