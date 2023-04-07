package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Tab_Gender extends JPanel {
	JRadioButton jrb_man;
	JRadioButton jrb_woman;
	JTextField jtf = new JTextField(20);
	
	public Tab_Gender() {
		
		//기본이 flowlayout이긴 함
		setLayout(new FlowLayout());
		jrb_man = new JRadioButton("남자");
		jrb_woman = new JRadioButton("여자");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb_man);
		bg.add(jrb_woman);
		add(jrb_man);
		add(jrb_woman);
		add(jtf);
		
		jrb_man.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("남자입니다.");
			}
		});
		
		jrb_woman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("여자입니다.");
			}
		});
	}
}