package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.CustomerDAO;
import vo.CustomerVO;

public class CustomerFrame extends JFrame {
	JTextField jtf_custid;
	JTextField jtf_name;
	JTextField jtf_address;
	JTextField jtf_phone;
	
	JTable table;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	public CustomerFrame() {
		colNames = new Vector<String>();
		colNames.add("고객번호");
		colNames.add("이름");
		colNames.add("주소");
		colNames.add("전화");
		
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_custid = new JTextField(10);
		jtf_name = new JTextField(10);
		jtf_address = new JTextField(10);
		jtf_phone = new JTextField(10);
		JPanel p = new JPanel();
		JButton btn_add = new JButton("등록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		p.add(new JLabel("고객번호"));
		p.add(jtf_custid);
		p.add(new JLabel("이름"));
		p.add(jtf_name);
		p.add(new JLabel("주소"));
		p.add(jtf_address);
		p.add(new JLabel("전화"));
		p.add(jtf_phone);
		p.add(btn_add);
		p.add(btn_update);
		p.add(btn_delete);
		
		setLayout(new BorderLayout());
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.NORTH);
		
		setSize(850,300);
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadCustomer();
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "정말로 삭제할까요?") != 0) {
					return;
				}
				int custid = Integer.parseInt(jtf_custid.getText());
				CustomerDAO dao = new CustomerDAO();
				int re = dao.deleteCustomer(custid);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "삭제 실패하였습니다.");
				}
			}
		});
		
		btn_update.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				int custid = Integer.parseInt(jtf_custid.getText());
				String name = jtf_name.getText();
				String address = jtf_address.getText();
				String phone = jtf_phone.getText();
				
				CustomerVO c = new CustomerVO(custid, name, address, phone);
				CustomerDAO dao = new CustomerDAO();
				int re = dao.updateCustomer(c);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
				}
			}
		});
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int custid = Integer.parseInt(jtf_custid.getText());
				String name = jtf_name.getText();
				String address = jtf_address.getText();
				String phone = jtf_phone.getText();
				
				CustomerVO c = new CustomerVO(custid, name, address, phone);
				CustomerDAO dao = new CustomerDAO();
				int re = dao.insertCustomer(c);
				if(re == 1) {
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
					loadCustomer();
				}else {
					JOptionPane.showMessageDialog(null, "등록에 실패했습니다.");
				}
			}
		});
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//테이블에서 선택한 행 인덱스를 갖고 옵니다.
				int row = table.getSelectedRow();
				//벡터에서 row번째에 있는 데이터를 갖고 옵니다.
				Vector<String> v = rowData.get(row);
				//갖고 온 데이터를 각각의 텍스트 필드에 출력합니다.
				jtf_custid.setText(v.get(0));
				jtf_name.setText(v.get(1));
				jtf_address.setText(v.get(2));
				jtf_phone.setText(v.get(3));
			}
		});
	}
	public void loadCustomer() {
		rowData.clear();
		CustomerDAO dao = new CustomerDAO();
		ArrayList<CustomerVO> list = dao.listCustomer();
		for(CustomerVO i:list) {
			Vector<String> v = new Vector<String>();
			v.add(i.getCustid()+"");
			v.add(i.getName());
			v.add(i.getAddress());
			v.add(i.getPhone());
			rowData.add(v);
		}
		table.updateUI();
	}
}
