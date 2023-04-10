package exam02;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IjaTest extends JFrame {
	
	
	public IjaTest() {
		JPanel p = new JPanel(new FlowLayout());
		
		JTextField jtf_money = new JTextField(10);
		JTextField jtf_rate = new JTextField(10);
		JLabel jlb_money = new JLabel("원금을 입력하시오");
		JLabel jlb_rate = new JLabel("이율을 입력하시오");
		JLabel jlb_result = new JLabel("", JLabel.CENTER);
		JButton btn = new JButton("변환");
		
		p.add(jlb_money);
		p.add(jtf_money);
		p.add(jlb_rate);
		p.add(jtf_rate);
		p.add(btn);
		setLayout(new GridLayout(2, 1));
		add(p);
		add(jlb_result);
		
		setTitle("이자 계산기");
		setSize(600,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double money = Double.parseDouble(jtf_money.getText());
				double rate = Double.parseDouble(jtf_rate.getText());
				jlb_result.setText("이자는 연 "+money*rate/100+"만원 입니다.");
			}
		});
	}
	public static void main(String[] args) {
		new IjaTest();
	}
}
