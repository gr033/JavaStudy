package exam04;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame {
	JTable table;
	
	public JTableTest() {
		String []colName = {"이름", "국어", "영어", "수학"};
		String [][]rowData = {{"Kim","65", "80", "90"},{"Lee","80","90","95"},
							{"Park","60","50","90"},{"Jo","50","60","90"}};
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTableTest();
	}
}
