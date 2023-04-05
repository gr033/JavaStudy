package exam06;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTest extends JFrame {
	public ButtonTest() {
		JButton btn = new JButton("확인");
		setLayout(new FlowLayout());
		btn.setBackground(Color.green);
		add(btn);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ButtonTest();
	}
}
