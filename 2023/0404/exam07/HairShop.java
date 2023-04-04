package exam07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HairShop extends JFrame implements ActionListener{
	JLabel jlb = new JLabel();
	int pay = 0;
	public HairShop() {
		jlb = new JLabel();
		JButton btn_man = new JButton("남자컷트");
		JButton btn_woman = new JButton("여자컷트");
		btn_man.addActionListener(this);
		btn_woman.addActionListener(this);
		setLayout(new FlowLayout());
		add(btn_man);
		add(btn_woman);
		add(jlb);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new HairShop();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//여자: 25000, 남자: 20000
		String cmd = e.getActionCommand();
		if(cmd.equals("여자컷트")) {
			pay = 25000;
		}else if(cmd.equals("남자컷트")){
			pay = 20000;
		}
		jlb.setText("요금은 "+pay+"원입니다.");
	}
}
