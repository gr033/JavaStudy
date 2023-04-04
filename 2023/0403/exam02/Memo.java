package exam02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame implements ActionListener{
	
	JTextArea jta;
	JFileChooser jfc;
	File file;
	
	public Memo() {
		jta = new JTextArea();
		jfc = new JFileChooser("c:/temp/");
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		JMenuBar jmb = new JMenuBar();
		JMenu mn_file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_exit.addActionListener(this);

		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		mn_file.add(file_exit);
		
		jmb.add(mn_file);
		
		setJMenuBar(jmb);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void openFile() {
		try {
			int re = jfc.showOpenDialog(this);
			if(re == 0) {
				file = jfc.getSelectedFile();
			}
			FileReader fr = new FileReader(file);
			int ch;
			String data = "";
			while((ch = fr.read()) != -1) {
				data += (char)ch;
			}
			fr.close();
			jta.setText(data);
		} catch (Exception ex) {
			System.out.println("예외발생: "+ex.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			int re = 9;
			if(file==null) {
				re = jfc.showSaveDialog(this);
			}
			if(re != 1) {
				if(re == 0) {
					file = jfc.getSelectedFile();
				}
			}
				String data = jta.getText();
				FileWriter fw = new FileWriter(file);
				fw.write(data);
				fw.close();
			JOptionPane.showMessageDialog(this, "파일을 저장했습니다.");
		} catch (Exception e2) {
			System.out.println("예외발생: "+e2.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Memo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("새파일")) {
			
		}else if(cmd.equals("열기")) {
			openFile();
		}
		else if(cmd.equals("저장")) {
			saveFile();
		}
		else if(cmd.equals("종료")) {
			System.exit(0);
		}
	}
}
