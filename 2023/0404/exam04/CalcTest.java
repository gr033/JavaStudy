package exam04;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcTest extends JFrame implements ActionListener{
	JTextField jtf;
	int op1;
	int op2;
	String op;
	JButton []btn = new JButton[16];
	String []str = {"1", "2", "3", "+",
					"4", "5", "6", "-", 
					"7", "8", "9", "*", 
					"0", "=", "C", "/"};
	public CalcTest() {
		JPanel p = new JPanel();
		jtf = new JTextField();
		p.setLayout(new GridLayout(4, 4));
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(str[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
			
		}
		
		setLayout(new BorderLayout());
		add(jtf, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setSize(200, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CalcTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			op1 = Integer.parseInt(jtf.getText());
			op = cmd;
			jtf.setText("");
		}else if(cmd.equals("=")) {
			op2 = Integer.parseInt(jtf.getText());
			switch(op){
			case "+": jtf.setText(op1+op2+""); break;
			case "-": jtf.setText(op1-op2+""); break;
			case "*": jtf.setText(op1*op2+""); break;
			case "/": jtf.setText(op1/op2+""); break;
			}
		}else if(cmd.equals("C")) {
				jtf.setText("");
				op1 = 0;
				op2 = 0;
				op = "";
		}
		else {
			jtf.setText(jtf.getText()+cmd);
			}
	}
}
