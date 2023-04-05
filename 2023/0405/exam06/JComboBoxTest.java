package exam06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBoxTest extends JFrame {
	JComboBox<String> jcb;
	JLabel jlb;
	
	public JComboBoxTest() {
		jlb = new JLabel();
		jcb = new JComboBox<String>();
		jcb.addItem("사람");
		jcb.addItem("행복");
		jcb.addItem("가족");
		jcb.addItem("돈");
		jcb.addItem("집");
		
		jcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)jcb.getSelectedItem();
				jlb.setText(item+"을(를) 선택하였습니다.");
			}
		});
		
		setLayout(new FlowLayout());
		add(jcb);
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new JComboBoxTest();
	}
}
