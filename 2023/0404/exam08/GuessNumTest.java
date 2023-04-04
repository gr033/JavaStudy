package exam08;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
	

public class GuessNumTest extends JFrame implements ActionListener{
	
	Random r;
	int random;
	JLabel jlb_highlow;
	JTextField jt;
	JButton jb_again;
	JButton jb_end;
	public GuessNumTest() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		r = new Random();
		random = r.nextInt(100)+1;
		jlb_highlow = new JLabel();
		jlb_highlow.setOpaque(true);
		jt = new JTextField(10);
		jb_again = new JButton("도전");
		jb_end = new JButton("종료");
		
		jb_again.addActionListener(this);
		jb_end.addActionListener(this);
		
		p1.add(new JLabel("숫자를 추측하시오: "));
		p1.add(jt);
		p2.add(jb_again);
		p2.add(jb_end);
		
		add(p1);
		add(jlb_highlow);
		add(p2);
		
		setLayout(new GridLayout(3,1));
		setTitle("숫자게임");
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GuessNumTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("도전")) {
			int x = Integer.parseInt(jt.getText());
			if(x>random) {
				jlb_highlow.setText("너무 높습니다.");
				jlb_highlow.setForeground(Color.white);
				jlb_highlow.setBackground(Color.magenta);
			}else if(x<random) {
				jlb_highlow.setText("너무 낮습니다.");
				jlb_highlow.setForeground(Color.white);
				jlb_highlow.setBackground(Color.cyan);
			}else {
				jlb_highlow.setText("정답입니다!!");
			}
		}
		if(cmd.equals("종료")) {
			System.exit(0);
		}
	}

}
