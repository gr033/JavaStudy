package exam03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
				//방송
				String msg = new String(data);
				sendAll(data);
				System.out.println("수신된 데이터: "+msg);
				if(msg.trim().equals("q!")) {
					break;
				}
				Arrays.fill(data, (byte)0);
			} catch (Exception e) {
				System.out.println("예외발생: "+e.getMessage());
			}//end catch
		}//end while
	}//run
	public void sendAll(byte []data) {
		for(ServerThread st:TCPChatServer.list) {
			try {
				st.os.write(data);
			} catch (Exception e) {
				System.out.println("예외발생: "+e.getMessage());
			}
		}
	}
}

public class TCPChatServer {

	static ArrayList<ServerThread> list;
	public static void main(String[] args) {
		list = new ArrayList<ServerThread>();
		try {
			ServerSocket server = new ServerSocket(9003);
			//클라이언트의 접속을 무한대기
			while(true) {
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속했습니다.");
				ServerThread th = new ServerThread(socket);
				list.add(th);
				th.start();
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}