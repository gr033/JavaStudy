package exam02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyEvent implements ActionListener{
	MyFrame mf;
	public MyEvent(MyFrame mf){
		this.mf =mf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		mf.jlb.setText("눌렀네");
	}
	
}
public class MyFrame extends JFrame {
	JLabel jlb;
	public MyFrame () {
		jlb = new JLabel("여기...");
		setLayout(new FlowLayout());
		JButton btn = new JButton("확인");
		add(jlb);
		add(btn);
		MyEvent me = new MyEvent(this);
		btn.addActionListener(me);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
