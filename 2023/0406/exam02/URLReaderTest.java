package exam02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLReaderTest extends JFrame {
	JTextArea jta;
	JButton btn1;
	JButton btn2;
	JTextField jtf;
	JFileChooser jfc;
	File file;
	
	public URLReaderTest() {
		JPanel p1 = new JPanel();
		btn1 = new JButton("읽기");
		btn2 = new JButton("저장");
		jtf = new JTextField(40);
		jta = new JTextArea();
		jfc = new JFileChooser("c:/temp/");
		p1.add(jtf);
		p1.add(btn1);
		p1.add(btn2);
		JScrollPane jsp = new JScrollPane(jta);
		btn1.addActionListener(new ActionListener() {
			String str = "";
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL(jtf.getText());
					InputStream is = url.openStream();
					byte []arr = new byte[100];
					while(is.read(arr) != -1) {
						str += new String(arr);
						Arrays.fill(arr, (byte)0);
					}
					is.close();
					jta.setText(str);
				} catch (Exception e2) {
					System.out.println("예외발생: "+e2.getMessage());
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int re = 9;
					if(file==null) {
						re = jfc.showSaveDialog(btn2);
					}
					if(re != 1) {
						if(re ==0) {
							file = jfc.getSelectedFile();
						}
					}
					String da = jta.getText();
					FileWriter fw = new FileWriter(file);
					fw.write(da);
					fw.close();
					JOptionPane.showMessageDialog(btn2, "파일을 저장했습니다.");
				} catch (Exception e2) {
					System.out.println("예외발생: "+e2.getMessage());
				}
			}
		});
		
		add(p1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(600, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new URLReaderTest();
	}
}
