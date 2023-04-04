package exam03;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
	public GridLayoutTest () {
		setLayout(new GridLayout(3, 5));
		for(int i=1;i<=14;i++) {
			add(new JButton("버튼"+i));
		}
		setSize(800,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GridLayoutTest();
	}
}