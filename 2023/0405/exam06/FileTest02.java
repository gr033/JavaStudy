package exam06;

import java.awt.FlowLayout;
import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FileTest02 extends JFrame {
	String path = "C:\\javaTest/day0309";
	Vector<String> data;
	JList<String> list;
	public FileTest02() {
		data = new Vector<>();
		File dir = new File(path);
		String []file_list = dir.list();
		list = new JList<>(file_list);
		
		setLayout(new FlowLayout());
		JScrollPane jsp = new JScrollPane(list);
		add(jsp);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {		
		new FileTest02();
	}
}
