package exam04;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextFieldTest extends JFrame {
	public TextFieldTest() {
		setLayout(new FlowLayout());
		add(new JTextField());
		add(new JTextField(3));
		add(new JTextField("hello"));
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new TextFieldTest();
	}
}
