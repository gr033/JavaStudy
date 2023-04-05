package exam06;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TiTacToeGame extends JFrame {
	JButton []btn = new JButton[9];
	String user = "O";
	
	public void fillColor(int []row) {
		for(int i=0;i<row.length;i++) {
			btn[row[i]].setBackground(Color.yellow);
		}
	}
	
	public boolean isFinish(String user) {
		boolean re = false;
		int [][]data = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},
						{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
		for(int []row:data) {
			//row : 0, 1, 2
			if(btn[row[0]].getText().equals(user) && btn[row[1]].getText().equals(user) && btn[row[2]].getText().equals(user)) {
				re = true;
				fillColor(row);
				break;
			}
		}
		return re;
	}
	
	public TiTacToeGame() {
		setLayout(new GridLayout(3, 3));
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton();
			add(btn[i]);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn2 = (JButton) e.getSource();
					Font font = new Font("굴림", Font.BOLD, 50);
					btn2.setFont(font);
					btn2.setText(user);
					btn2.setEnabled(false);
					if(isFinish(user)) {
//						System.out.println(user+"가 이겼습니다.");
						for(JButton b:btn) {
							b.setEnabled(false);
						}
						JOptionPane.showMessageDialog(null, user+"가 이겼습니다.");
					}
					if(user.equals("O")) {
						user="X";
					}else {
						user = "O";
					}
				}
			});
		}
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new TiTacToeGame();
	}
}
