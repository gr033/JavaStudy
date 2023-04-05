package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class HairEvent{
public class Test extends JFrame{
	JLabel jlb = new JLabel();
	int pay = 0;
	public Test() {
		jlb = new JLabel();
		JButton btn_man = new JButton("남자컷트");
		JButton btn_woman = new JButton("여자컷트");
		btn_man.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay = 20000;
				jlb.setText("요금은 "+pay+"원입니다.");
			}
		});
		btn_woman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pay = 25000;
				jlb.setText("요금은 "+pay+"원입니다.");
			}
		});
		setLayout(new FlowLayout());
		add(btn_man);
		add(btn_woman);
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new HairEvent();
	}
}
}