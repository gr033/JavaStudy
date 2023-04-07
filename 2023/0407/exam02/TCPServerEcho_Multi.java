package exam02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.util.Arrays;

class ServerThread extends Thread{
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
	public void run() {
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data);
				os.write(data);
				String msg = new String(data);
				System.out.println("수신된 데이터: "+msg);
				if(msg.trim().equals("q!")) {
					break;
				}
				Arrays.fill(data, (byte)0);
			} catch (Exception e) {
				System.out.println("예외발생: "+e.getMessage());
			}
			
		}
	}
}

public class TCPServerEcho_Multi {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9003);
			//클라이언트의 접속을 무한대기
			while(true) {
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속했습니다.");
				//클라이언트와 대화(메아리 포함)
				new ServerThread(socket).start();
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}