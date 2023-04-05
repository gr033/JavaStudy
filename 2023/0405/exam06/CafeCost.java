package exam06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CafeCost extends JFrame {
	JLabel jlb;
	int price = 0;
	String []menu = {"Small", "Medium", "Large"};
	JRadioButton []jrb = new JRadioButton[menu.length];
	int []cost = {3000, 4000, 5000};
	ButtonGroup bg_menu;
	
	public CafeCost() {
		setTitle("커피 가격 계산");
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		jlb = new JLabel();
		bg_menu = new ButtonGroup();
		
		
		p1.setLayout(new GridLayout(4, 2));
		p1.add(new JLabel("커피 크기"));
		p1.add(new JLabel("가격(원)"));
		//반복문을 모두 수행했을 때의 가격
		for(int i=0;i<menu.length;i++) {
			jrb[i] = new JRadioButton(menu[i]);
			bg_menu.add(jrb[i]);
			p1.add(jrb[i]);
			p1.add(new JLabel(cost[i]+"원"));
			//라디오가 눌렸을 때에 i의 값은 3입니다.
			jrb[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					price = 0;
					for(int j=0;j<menu.length;j++) {
						
						if(jrb[j].isSelected()) {
							price = cost[j];
						}
					}
					jlb.setText(price+"원");
				}
			});
		}
		
		p2.add(new JLabel("가격: "));
		p2.add(jlb);
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CafeCost();
	}
}
