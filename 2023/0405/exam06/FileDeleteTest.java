package exam06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FileDeleteTest extends JFrame {
	public FileDeleteTest() {
		setLayout(new FlowLayout());
		JButton btn = new JButton("file delete");
		add(btn);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = "C:/javaTest/day0309";
				String fname = "HelloTest.java";
				File file = new File(path+"/"+fname);
				file.delete();
			}
		});
	}
	public static void main(String[] args) {
		new FileDeleteTest();
	}
}
