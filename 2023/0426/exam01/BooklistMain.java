package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BooklistMain extends JFrame {
	JTextField jtf_name;
	JTable table;
	Vector<Vector<String>> rowData;
	Vector<String> colNames;
	
	public BooklistMain() {
		JButton btn = new JButton("추천받기");
		colNames = new Vector<>();
		jtf_name = new JTextField(15);
		colNames.add("책번호");
		colNames.add("책이름");
		colNames.add("출판사");
		colNames.add("정가");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		JPanel p = new JPanel();
		p.add(new JLabel("고객님의 이름을 입력해주세요"));
		p.add(jtf_name);
		p.add(btn);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rowData.clear();
				String name = jtf_name.getText();
				BooklistDAO dao = new BooklistDAO();
				ArrayList<BooklistVO> list = dao.bookRecommend(name);
				for(BooklistVO vo:list) {
					Vector<String> v = new Vector<>();
					v.add(vo.getBookid()+"");
					v.add(vo.getBookname());
					v.add(vo.getPublisher());
					v.add(vo.getPrice()+"");
					rowData.add(v);
				}
				table.updateUI();
			}
		});
	}
	public static void main(String[] args) {
		new BooklistMain();
	}
}
