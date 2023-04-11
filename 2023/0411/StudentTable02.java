package exam01;
//데이터베이스 연결하여 모든 학생의 이름,국어,영어,수학을
//JTable에 출력하도록 합니다.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class StudentTable02 extends JFrame {
	JTable table;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	public StudentTable02() {
		colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("국어");
		colNames.add("영어");
		colNames.add("수학");
		
		rowData = new Vector<Vector<String>>();
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		readStudent();		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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














