package exam02;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MemberGUI extends JFrame {
	public MemberGUI() {
		
		setLayout(new BorderLayout());
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MemberGUI();
	}
}
