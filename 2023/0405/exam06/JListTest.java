package exam06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class JListTest extends JFrame {
	Vector<String> data;
	JList<String> list;
	JTextField jtf;
	
	public JListTest() {
		data = new Vector<String>();
		data.add("핸드폰");
		data.add("건강");
		data.add("집");
		data.add("가족");
		data.add("돈");
		list = new JList<String>(data);
		jtf = new JTextField(10);
		setLayout(new FlowLayout());
		add(list);
		add(jtf);
		JButton btn = new JButton("추가");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String item = jtf.getText();
			data.add(item);
			list.updateUI();
			}
		});
		add(btn);
		setSize(170,300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JListTest();
	}
}