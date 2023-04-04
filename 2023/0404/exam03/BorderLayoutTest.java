package exam03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		setLayout(new BorderLayout());
		setSize(400,300);
		add(new JButton("위"), BorderLayout.NORTH);
		add(new JButton("아래"), BorderLayout.SOUTH);
		add(new JButton("왼쪽"), BorderLayout.WEST);
		add(new JButton("오른쪽"), BorderLayout.EAST);
		add(new JButton("가운데"), BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}