package exam07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxTest extends JFrame implements ActionListener{
	JCheckBox jcb_apple;
	JCheckBox jcb_grape;
	JLabel jlb_result;
	public JCheckBoxTest() {
		jcb_apple = new JCheckBox("사과");
		jcb_grape = new JCheckBox("포도");
		jlb_result = new JLabel();
		jcb_apple.addActionListener(this);
		jcb_grape.addActionListener(this);
		setLayout(new FlowLayout());
		add(jcb_apple);
		add(jcb_grape);
		add(jlb_result);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = "";
		if(jcb_apple.isSelected() == true && jcb_grape.isSelected() == true) {
			str = "사과, 포도 모두 선택했습니다.";
			
		}else if(jcb_apple.isSelected()==true && jcb_grape.isSelected() == false) {
			str = "사과만 선택했습니다.";
			
		}else if(jcb_apple.isSelected()==false && jcb_grape.isSelected() == true) {
			str = "포도만 선택했습니다.";
		}
		else {
			str = "아무것도 선택하지 않았습니다.";
		}
		jlb_result.setText(str);
//		System.out.println("사과의 상태: "+jcb_apple.isSelected());
//		System.out.println("포도의 상태: "+jcb_grape.isSelected());
	}
}
