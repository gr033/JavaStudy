package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class HairEvent implements ActionListener{
	private Test hs;
	public HairEvent (Test hs) {
		this.hs = hs;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("여자컷트")) {
			hs.pay = 25000;
		}else if(cmd.equals("남자컷트")){
			hs.pay = 20000;
		}
		hs.jlb.setText("요금은 "+hs.pay+"원입니다.");
		}
	}

public class Test extends JFrame{
	JLabel jlb = new JLabel();
	int pay = 0;
	public Test() {
		HairEvent he = new HairEvent(this);
		
		jlb = new JLabel();
		JButton btn_man = new JButton("남자컷트");
		JButton btn_woman = new JButton("여자컷트");
		btn_man.addActionListener(he);
		btn_woman.addActionListener(he);
		setLayout(new FlowLayout());
		add(btn_man);
		add(btn_woman);
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Test();
	}
}
