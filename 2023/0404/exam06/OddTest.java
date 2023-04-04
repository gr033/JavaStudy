package exam06;
//임의의 수를 입력받아 짝수인지 홀수인지 판별하는 프로그램 GUI
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OddTest extends JFrame implements ActionListener{
	JTextField jtf;
	JLabel jl;
	public OddTest() {
		jtf = new JTextField(5);
		JButton jb = new JButton("확인");
		jl = new JLabel();
		jb.addActionListener(this);
		setSize(400, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new JLabel("짝수 판별: 숫자를 입력하세요."));
		add(jtf);
		add(jb);
		add(jl);
	}
	public static void main(String[] args) {
		new OddTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		int x = Integer.parseInt(jtf.getText());
		String r = "짝수입니다.";
		if(x%2==1) {
			r = "홀수입니다.";
		}
		jl.setText(r);
	}
}
