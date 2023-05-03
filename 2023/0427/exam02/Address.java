package exam02;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sist.dao.BookDAO;

import db.ConnectionProvider;

public class Address extends JFrame {
	public Address() {
		JButton btn = new JButton("변경");
		JTextField jtf_name = new JTextField(15);
		JTextField jtf_address = new JTextField(15);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		setLayout(new GridLayout(3,1));
		
		p1.add(new JLabel("이름: "));
		p1.add(jtf_name);
		p2.add(new JLabel("변경할 주소: "));
		p2.add(jtf_address);
		p3.add(btn);
		
		add(p1);
		add(p2);
		add(p3);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDAO dao = new BookDAO();
				int r = dao.changeAddress(jtf_name.getText(), jtf_address.getText());
				if(r==-1) {
					JOptionPane.showMessageDialog(null, "변경 실패");
				}else {
					JOptionPane.showMessageDialog(null, "변경 성공");
				}
			}
		});
	}
	public static void main(String[] args) {
		new Address();
	}
}
