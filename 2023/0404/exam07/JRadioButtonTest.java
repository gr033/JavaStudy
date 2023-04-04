package exam07;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame implements ActionListener{
	JRadioButton jrd_man;
	JRadioButton jrd_woman;
	JLabel jlb_result;
	JRadioButton jrd_a;
	JRadioButton jrd_b;
	JRadioButton jrd_ab;
	JRadioButton jrd_o;
	JLabel jlb_result2;
	
	public JRadioButtonTest() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		setLayout(new GridLayout(2, 1));
		ButtonGroup bg_gender = new ButtonGroup();
		jrd_man = new JRadioButton("남자");
		jrd_woman = new JRadioButton("여자");
		bg_gender.add(jrd_man);
		bg_gender.add(jrd_woman);
		jrd_man.addActionListener(this);
		jrd_woman.addActionListener(this);
		jlb_result = new JLabel();
		p1.add(jrd_man);
		p1.add(jrd_woman);
		p1.add(jlb_result);
		//혈액형 화면 구성
		jrd_a = new JRadioButton("A형");
		jrd_b = new JRadioButton("B형");
		jrd_ab = new JRadioButton("AB형");
		jrd_o = new JRadioButton("O형");
		jlb_result2 = new JLabel();
		jrd_a.addActionListener(this);
		jrd_b.addActionListener(this);
		jrd_ab.addActionListener(this);
		jrd_o.addActionListener(this);
		ButtonGroup bg_blood = new ButtonGroup();
		bg_blood.add(jrd_a);
		bg_blood.add(jrd_b);
		bg_blood.add(jrd_ab);
		bg_blood.add(jrd_o);
		p2.add(jrd_a);
		p2.add(jrd_b);
		p2.add(jrd_ab);
		p2.add(jrd_o);
		p2.add(jlb_result2);
		add(p1);
		add(p2);
		
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JRadioButtonTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("남자") || cmd.equals("여자")) {
			jlb_result.setText(cmd+"입니다.");
		}else {
			jlb_result2.setText(cmd+"입니다.");
		}
	}
}