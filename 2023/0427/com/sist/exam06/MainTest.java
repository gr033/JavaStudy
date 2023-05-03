package com.sist.exam06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;

public class MainTest extends JFrame {
	JTextField jtf_name;
	JTextField jtf_addr;
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public MainTest() {
		jtf_addr = new JTextField(20);
		jtf_name = new JTextField(20);
		colNames = new Vector<String>();
		colNames.add("항목");
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		JPanel p = new JPanel();
		JButton btn_search = new JButton("조회");
		JButton btn_update = new JButton("변경");
		
		p.add(new JLabel("이름: "));
		p.add(jtf_name);
		p.add(btn_search);
		p.add(btn_update);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("바꿀 주소: "));
		p1.add(jtf_addr);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(jsp, BorderLayout.CENTER);
		p2.add(p1, BorderLayout.SOUTH);
		
		add(p, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				CustomerDAO dao = new CustomerDAO();
				dao.updateAddr(name, addr);
				loadData();
			}
		});
	}
	public void loadData() {
		rowData.clear();
		String name = jtf_name.getText();
		CustomerDAO dao = new CustomerDAO();
		CustomerVO c = dao.getCustomer(name);
		Vector<String> v1 = new Vector<>();
		v1.add(name);
		Vector<String> v2 = new Vector<>();
		v2.add(c.getAddress());
		Vector<String> v3 = new Vector<>();
		v3.add(c.getPhone());
		rowData.add(v1);
		rowData.add(v2);
		rowData.add(v3);
		table.updateUI();
	}
	public static void main(String[] args) {
		new MainTest();
	}
}
