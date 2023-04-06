package exam02;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {

	public static void main(String[] args) {
		Random r = new Random();
		try {
			ServerSocket server = new ServerSocket(9001);
			System.out.println("***서버 가동***");
			while(true) {
				Socket socket= server.accept();
				System.out.println("***클라이언트 접속***");
				Thread.sleep(3000);
				OutputStream os = socket.getOutputStream();
				for(int i=1;i<=10;i++) {
					int n = r.nextInt(100);
					os.write(n);
					Thread.sleep(100);
				}
				os.close();
				socket.close();
			}
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
	}
}
