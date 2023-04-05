package exam06;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageButtonTest extends JFrame {
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	JButton btn;
	public ImageButtonTest() {
		icon1 = new ImageIcon("error1.png");
		icon2 = new ImageIcon("error2.png");
		icon3 = new ImageIcon("error3.png");
		btn = new JButton(icon1);
		btn.setRolloverIcon(icon2);
		
		setLayout(new FlowLayout());
		add(btn);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImageButtonTest();
	}
}
