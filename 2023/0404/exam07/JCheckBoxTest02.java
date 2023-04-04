package exam07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxTest02 extends JFrame implements ActionListener{
	String []str  = {"사과", "포도", "배", "감", "오렌지", "수박"};
	JCheckBox []jcb = new JCheckBox[str.length];
	JLabel jlb_result;
	public JCheckBoxTest02() {
		setLayout(new FlowLayout());
		for(int i=0;i<str.length;i++) {
			jcb[i] = new JCheckBox(str[i]);
			add(jcb[i]);
			jcb[i].addActionListener(this);
		}
		jlb_result = new JLabel();
		add(jlb_result);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new JCheckBoxTest02();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String data = "";
		for(int i=0;i<jcb.length;i++) {
			if(jcb[i].isSelected()) {
				data = data+jcb[i].getText()+", ";
			}
		}
		
		if(!data.equals("")){
			data = data.substring(0, data.length()-2);
			jlb_result.setText(data+"를(을) 선택하였습니다.");
		} 
		else {
			jlb_result.setText("아무것도 선택하지 않았습니다.");
		}
	}
}
