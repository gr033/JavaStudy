package exam03;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {
	public FlowLayoutTest () {
		setLayout(new FlowLayout());
		for(int i=1;i<=15;i++) {
			add(new JButton("버튼"+i));
		}
		setSize(800,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FlowLayoutTest();
		
	}
}