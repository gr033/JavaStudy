package exam06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarCenter extends JFrame {
	int total = 0;
	int []price = {45000, 80000, 30000, 100000};
	
	String []str = {"엔진 오일 교환", "자동 변속기 오일 교환", "에어컨 필터 교환", "타이어 교환"};
	JCheckBox []jcb = new JCheckBox[str.length];
	JLabel jlb;
	public CarCenter() {
		setTitle("쌍용 자동차 정비소");
		setLayout(new BorderLayout());
		jlb = new JLabel();
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(new GridLayout(4,1));
		for(int i=0;i<jcb.length;i++) {
			jcb[i] = new JCheckBox(str[i]);
			p1.add(jcb[i]);
			jcb[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					total = 0;
					for(int j=0;j<jcb.length;j++) {
						if(jcb[j].isSelected()) {
							total += price[j];
						}
					}
					jlb.setText(total+"원");
				}
			});
		}
		
		p2.add(new JLabel("전체 가격: "));
		p2.add(jlb);
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CarCenter();
	}
}
