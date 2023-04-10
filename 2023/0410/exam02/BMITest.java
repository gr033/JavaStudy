package exam02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMITest extends JFrame {
	JTextField jtf_height;
	JTextField jtf_weight;
	JButton btn;
	double bmi;
	
	public BMITest() {
		JLabel jlb_how = new JLabel("나의 BMI지수는 얼마나 나올까?");
		JLabel jlb_weight = new JLabel("나의 체중(kg)");
		JLabel jlb_height = new JLabel("나의 키(m)");
		JLabel jlb_result = new JLabel("");
		jtf_height = new JTextField();
		jtf_weight = new JTextField();
		btn = new JButton("BMI 확인하기");
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 2));
		p.add(jlb_weight);
		p.add(jtf_weight);
		p.add(jlb_height);
		p.add(jtf_height);
		p.add(btn);
		p.add(jlb_result);
		
		setLayout(new BorderLayout());
		add(jlb_how, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setTitle("BMI 계산기");
		setSize(400,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double weight = Double.parseDouble(jtf_weight.getText());
				double height = Double.parseDouble(jtf_height.getText());
				bmi = weight/(height*height);
				jlb_result.setText(String.format("당신의 BMI지수: %.2f", bmi));
			}
		});
	}
	
	public static void main(String[] args) {
		new BMITest();
	}
}
