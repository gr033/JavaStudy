package exam04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableTestVectorInput extends JFrame {
	int row;
	JTable table;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	JTextField jtf_name; 
	JTextField jtf_kor; 
	JTextField jtf_eng; 
	JTextField jtf_math; 
	public JTableTestVectorInput() {
		colName = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colName.add("이름");
		colName.add("국어");
		colName.add("영어");
		colName.add("수학");
		colName.add("총점");
		colName.add("평균");
		
		Vector<String> v1 = new Vector<>();
		Vector<String> v2 = new Vector<>();
		
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		JPanel p2 = new JPanel(new FlowLayout());
		
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		
		JButton btn_add = new JButton("추가");
		JButton btn_change = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		JLabel jlb_name = new JLabel("이름");
		JLabel jlb_kor = new JLabel("국어");
		JLabel jlb_eng = new JLabel("영어");
		JLabel jlb_math = new JLabel("수학");
		jtf_name = new JTextField(10); 
		jtf_kor = new JTextField(10); 
		jtf_eng = new JTextField(10);
		jtf_math = new JTextField(10); 
		
		setLayout(new BorderLayout());
		
		JPanel p = new JPanel(new BorderLayout());
		p1.add(jlb_name);
		p1.add(jtf_name);
		p1.add(jlb_kor);
		p1.add(jtf_kor);
		p1.add(jlb_eng);
		p1.add(jtf_eng);
		p1.add(jlb_math);
		p1.add(jtf_math);
		
		p2.add(btn_add);
		p2.add(btn_change);
		p2.add(btn_delete);
		
		p.add(p1, BorderLayout.CENTER);
		p.add(p2, BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> row = new Vector<String>();
				row.add(jtf_name.getText());
				row.add(jtf_kor.getText());
				row.add(jtf_eng.getText());
				row.add(jtf_math.getText());
				row.add(getSum());
				row.add(getAvg());
				rowData.add(row);
				table.updateUI();
				jtf_name.setText("");
				jtf_kor.setText("");
				jtf_eng.setText("");
				jtf_math.setText("");
			}
		});
		
		btn_change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> v = new Vector<String>();
				v.add(jtf_name.getText());
				v.add(jtf_kor.getText());
				v.add(jtf_eng.getText());
				v.add(jtf_math.getText());
				v.add(getSum());
				v.add(getAvg());
				
				rowData.set(row, v);
				table.updateUI();
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int re = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
				if(re==0) {
					rowData.remove(row);
					table.updateUI();
					jtf_name.setText("");
					jtf_kor.setText("");
					jtf_eng.setText("");
					jtf_math.setText("");
				}
			}
		});

		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	
	public String getSum(){
		int kor = Integer.parseInt(jtf_kor.getText());
		int eng = Integer.parseInt(jtf_eng.getText());
		int math = Integer.parseInt(jtf_math.getText());
		return kor+eng+math+"";
	}
	
	public String getAvg() {
		
		return String.format("%.2f", Double.parseDouble(getSum())/3);
		
	}
	
	public static void main(String[] args) {
		new JTableTestVectorInput();
	}
}
