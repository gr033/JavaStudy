package exam05;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGame extends JFrame {
	int com;
	int user;
	JTextField jtf;
	JLabel jlb;
	
	public NumberGame() {
		Random r = new Random();
		com = r.nextInt(100)+1;
		jtf = new JTextField(10);
		jlb = new JLabel();
		jtf.setBackground(Color.yellow);
		//라벨 색 설정하기 위해 필요함
		jlb.setOpaque(true);
		
		setLayout(new GridLayout(3, 1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		p1.add(new JLabel("숫자를 추측하세요: "));
		p1.add(jtf);
		p2.add(jlb);
		
		JButton btn01 = new JButton("다시 한번");
		JButton btn02 = new JButton("종료");
		
		btn01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user = Integer.parseInt(jtf.getText());
				if(user>com) {
					jlb.setText("너무 높습니다");
					jlb.setBackground(Color.pink);
				}else if(user<com) {
					jlb.setText("너무 낮습니다.");
					jlb.setBackground(Color.cyan);
				}else {
					jlb.setText("정답입니다!");
					jlb.setBackground(Color.green);
				}
			}
		});
		btn02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		p3.add(btn01);
		p3.add(btn02);
		
		add(p1);
		add(p2);
		add(p3);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		}
	public static void main(String[] args) {
		new NumberGame();
	}

}
