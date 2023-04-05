package exam06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JListTest02 extends JFrame {
	Vector<String> data;
	JList<String> list;
	JTextField jtf;
	
	public JListTest02() {
		data = new Vector<String>();
		data.add("핸드폰");
		data.add("건강");
		data.add("집");
		data.add("가족");
		data.add("돈");
		list = new JList<String>(data);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("OK");
				String value = list.getSelectedValue();
				jtf.setText(value);
			}
		});
		jtf = new JTextField(10);
		setLayout(new FlowLayout());
		add(list);
		add(jtf);
		JButton btn = new JButton("추가");
		JButton btn_del = new JButton("삭제");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String item = jtf.getText();
			data.add(item);
			list.updateUI();
			}
		});
		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = jtf.getText();
				if(item.equals("")) {
					JOptionPane.showMessageDialog(null, "삭제할 항목을 선택하십시오");
					return;
				}
				data.remove(item);
				list.updateUI();
				jtf.setText("");
			}
		});
		
		add(btn);
		add(btn_del);
		setSize(170,300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JListTest02();
	}
}