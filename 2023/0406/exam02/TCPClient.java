package exam02;

import java.io.InputStream;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) {
		try {
			String host = "211.238.142.172";
			int port = 9001;
			Socket socket = new Socket(host, port);
			System.out.println("***서버 연결***");
			InputStream is = socket.getInputStream();
			for(int i=1;i<=10;i++) {
				int n = is.read();
				System.out.println("서버로부터 수신된 데이터:"+n);
			}
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
	}
}
