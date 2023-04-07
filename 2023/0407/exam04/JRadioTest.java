package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class JRadioTest extends JFrame {
	
	String []key = {"사과", "바나나", "포도", "복숭아", "감"};
	String []value = {"apple.png", "banana.jpg", "grape.png", "peach.png", "persimmon.jpeg"};
	HashMap<String, String> map;
	JRadioButton []jrb = new JRadioButton[key.length];
	JLabel jlb;
	ImageIcon icon01;
	
	public JRadioTest() {
		icon01 = new ImageIcon("apple.png");
		jlb = new JLabel();
		map = new HashMap<String, String>();
		setLayout(new FlowLayout());
		ButtonGroup bg = new ButtonGroup();
		for(int i=0;i<key.length;i++) {
			jrb[i] = new JRadioButton(key[i]);
			map.put(key[i], value[i]);
			bg.add(jrb[i]);
			add(jrb[i]);
			
			jrb[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String key = ((JRadioButton)e.getSource()).getText();
					String fname = map.get(key);
					icon01 = new ImageIcon(fname);
					jlb.setIcon(icon01);
				}
			});
		}
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JRadioTest();
	}
}
