package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileTest extends JFrame {
	JList<String> list;
	JTextArea jta;
	Vector<String> data;
	String path = "C:\\javaTest\\Test";
	
	public void loadFileList() {
		File dir = new File(path);
		String []file_list = dir.list();
//		String []file_list = dir.list(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.endsWith(".java");
//			}
//		});
		for(String fname:file_list) {
			File f = new File(path+"/"+fname);
			if(f.isFile()) {
				String ext = fname.substring(fname.lastIndexOf("."));
				if(ext.equals(".java")) {
					data.add(fname);
				}
			}
		}
		list.updateUI();
	}
	public FileTest() {
		data = new Vector<String>();
		list = new JList<String>(data);
		jta = new JTextArea(10, 80);
		JScrollPane jsp_jta = new JScrollPane(jta);
		JScrollPane jsp_list = new JScrollPane(list);
		JButton btn = new JButton("읽어오기");
		JPanel p1 = new JPanel();
		
		p1.setLayout(new BorderLayout());
		p1.add(jsp_list, BorderLayout.CENTER);
		p1.add(btn, BorderLayout.SOUTH);
		
		add(p1, BorderLayout.WEST);
		add(jsp_jta, BorderLayout.CENTER);
		loadFileList();
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = list.getSelectedValue();
				if(fname != null) {
					readFile(fname);
				}
			}
		});
	}
	
	protected void readFile(String fname) {
		try {
			FileReader fr = new FileReader(path+"/"+fname);
			int ch;
			String str = "";
			while((ch = fr.read())!=-1) {
				str += (char)ch;
			}
			jta.setText(str);
			fr.close();
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new FileTest();
	}
}
