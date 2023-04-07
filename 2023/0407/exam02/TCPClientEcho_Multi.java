package exam02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TCPClientEcho_Multi extends JFrame{
	JTextField jtf;
	JTextArea jta;
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public TCPClientEcho_Multi() {
		
		jtf = new JTextField();
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		p.setLayout(new BorderLayout());
		JButton btn_send = new JButton("전송");
		JButton btn_exit = new JButton("종료");
		p2.add(btn_send);
		p2.add(btn_exit);
		p.setLayout(new BorderLayout());
		p.add(jtf, BorderLayout.CENTER);
		p.add(p2, BorderLayout.EAST);
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		try {
			socket = new Socket("localhost", 9003);
			jta.append("서버에 연결했습니다.\n");
			is = socket.getInputStream();
			os = socket.getOutputStream();
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn_send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = jtf.getText();
				byte []data = msg.getBytes();
				try {
					os.write(data);
					System.out.println("메세지: "+msg);
					jtf.setText("");
					if(msg.trim().equals("q!")) {
						jta.append("채팅방을 나갑니다.");
					}
				} catch (Exception e2) {
					System.out.println("예외발생: "+e2.getMessage());
				}
			}
		});
		
		//서버로부터 수신되는 데이터를 받기위한 Thread생성
		class ClientThread extends Thread{
			byte []data = new byte[100];
			public void run() {
				while(true) {
					try {
						is.read(data);
						String msg = new String(data);
						jta.append(msg+"\n");
						Arrays.fill(data, (byte)0);
					} catch (Exception e) {
						System.out.println("예외발생: "+e.getMessage());
					}
				}
			}
		}
		
		new ClientThread().start();
	}
	public static void main(String[] args) {
		new TCPClientEcho_Multi();
	}
}
