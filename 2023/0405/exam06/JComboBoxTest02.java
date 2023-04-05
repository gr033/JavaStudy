package exam06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest02 extends JFrame {
	Color []myColor = {Color.red, Color.blue, Color.green, Color.orange};
	JComboBox<String> jcb;
	Vector<String> data;
	JPanel p;
	public JComboBoxTest02() {
		data = new Vector<String>();
		p = new JPanel();
		data.add("Red");
		data.add("Blue");
		data.add("Green");
		data.add("Orange");
		jcb = new JComboBox<String>	(data);
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = jcb.getSelectedIndex();
				p.setBackground(myColor[i]);
			}
		});
		
		setLayout(new BorderLayout());
		add(jcb, BorderLayout.NORTH);
		setSize(400,300);
		add(p, BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JComboBoxTest02();
	}
}
