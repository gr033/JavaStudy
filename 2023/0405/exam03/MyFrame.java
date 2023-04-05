package exam03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	JLabel jlb;
	public MyFrame () {
		jlb = new JLabel("여기...");
		setLayout(new FlowLayout());
		JButton btn = new JButton("확인");
		add(jlb);
		add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb.setText("자네 그 버튼을 눌러버렸구만");
				System.out.println("눌렀구만");
			}
		});
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
