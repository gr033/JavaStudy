package exam04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tab_Blood extends JPanel {
	String data[] = {"A형", "B형", "AB형", "O형"};
	JCheckBox []jcb = new JCheckBox[data.length];
	JTextField jtf;
	public Tab_Blood() {
		jtf = new JTextField(20);
		for(int i=0; i<data.length;i++) {
			jcb[i]= new JCheckBox(data[i]);
			add(jcb[i]);
			jcb[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = "";
					for(int i=0; i<jcb.length;i++) {
						if(jcb[i].isSelected()) {
							str += jcb[i].getText()+", ";
						}
					}
					if(str.equals("")) {
						jtf.setText("혈액형을 선택하세요.");
					}else {
						str = str.substring(0, str.length()-2);
						jtf.setText("우리가족의 혈액형: " + str);
					}
				}
			});
		}
		add(jtf);
	}
}
