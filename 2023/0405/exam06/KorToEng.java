package exam06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KorToEng extends JFrame {
	JTextArea jta01;
	JTextArea jta02;
	HashMap<String, String> map = new HashMap<>();
	public KorToEng() {
		map = new HashMap<String, String>();
		map.put("텍스트", "Text");
		map.put("영어", "English");
		map.put("단어", "Word");
		jta01 = new JTextArea();
		jta02 = new JTextArea();
		JScrollPane jsp01 = new JScrollPane(jta01);
		JScrollPane jsp02 = new JScrollPane(jta02);
		
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(1, 2, 10, 0));
		p1.add(jsp01);
		p1.add(jsp02);
		
		JButton btn01 = new JButton("변환");
		JButton btn02 = new JButton("취소");
		
		btn01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = jta01.getText();
				Iterator<String> iter = map.keySet().iterator();
				while(iter.hasNext()) {
					String key = iter.next();
					String value = map.get(key);
					data = data.replaceAll(key, value);
				}
				jta02.setText(data);
			}
		});
		btn02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta02.setText("");
			}
		});
		
		p2.add(btn01);
		p2.add(new JLabel("   "));
		p2.add(btn02);
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setTitle("텍스트 변환");
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new KorToEng();
	}

}
