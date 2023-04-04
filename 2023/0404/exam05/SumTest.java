package exam05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SumTest extends JFrame implements ActionListener{
	JTextField jtf;
	JButton btn;
	JLabel jlb;
	public SumTest() {
		jtf = new JTextField(5);
		btn = new JButton("확인");
		jlb = new JLabel();
		btn.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(new JLabel("어디까지 더할까요?"));
		add(jtf);
		add(btn);
		add(new JLabel("결과"));
		add(jlb);
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SumTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		int sum = 0;
		int x = Integer.parseInt(jtf.getText());
		for(int i=1;i<=x;i++) {
			sum += i;
		}
		jlb.setText(sum+"");
	}
}
