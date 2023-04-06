package exam02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPSenderGUI extends JFrame {
	
	JTextArea jta;
	JTextField jtf;
	InetAddress addr;
	int port;
	DatagramSocket socket;
	
	public UDPSenderGUI() {
		try {
			socket = new DatagramSocket();
			addr = InetAddress.getByName("localhost");
			port = 9002;
		}catch(Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		jta = new JTextArea();
		jtf = new JTextField();
		JScrollPane jsp = new JScrollPane(jta);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		JButton btn_send = new JButton("전송");
		p.add(jtf, BorderLayout.CENTER);
		p.add(btn_send, BorderLayout.EAST);
		
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		class ClientThread extends Thread{
			byte []data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			public void run() {
				while(true) {
					try {
						socket.receive(packet);
						String msg = new String(data);
						jta.append(msg+"\n");
					} catch (Exception e) {
						System.out.println("예외발생: "+e.getMessage());
					}
				}//end while
			}//end run
		}//end inner class
		
		new ClientThread().start();
		
		btn_send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = jtf.getText();
				byte []data = msg.getBytes();
				DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
				try {
					socket.send(packet);
				} catch (Exception ex) {
					System.out.println("예외발생: "+ex.getMessage());
				}
			}
		});
		jtf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				String msg = jtf.getText();
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					byte[] data = msg.getBytes();
					DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
					jtf.setText("");
					try {
						socket.send(packet);
					} catch (Exception ex) {
						System.out.println("예외발생: "+ex.getMessage());
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new UDPSenderGUI();
	}

}
