package exam04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTestVector extends JFrame {
	JTable table;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	public JTableTestVector() {
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colName.add("이름");
		colName.add("국어");
		colName.add("영어");
		colName.add("수학");
		
		Vector<String> v1 = new Vector<>();
		v1.add("Kim");
		v1.add("85");
		v1.add("90");
		v1.add("75");
		
		Vector<String> v2 = new Vector<>();
		v2.add("Lee");
		v2.add("90");
		v2.add("80");
		v2.add("100");

		rowData.add(v1);
		rowData.add(v2);
		
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);
		
		JButton btn = new JButton("추가");
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> row = new Vector<String>();
				row.add("홍길동");
				row.add("100");
				row.add("100");
				row.add("100");
				
				rowData.add(row);
				
				table.updateUI();
			}
		});
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTableTestVector();
	}
}
