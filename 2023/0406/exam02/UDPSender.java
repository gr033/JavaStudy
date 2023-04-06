package exam02;
//java UDPsender localhost 9002 hello?
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	
	public static void main(String[] args) {
		try {
			InetAddress addr = InetAddress.getByName(args[0]);
			int port = Integer.parseInt(args[1]);
			byte []data = args[2].getBytes();
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			
		} catch (Exception e) {
			System.out.println("예외 발생: "+e.getMessage());
		}
	}
}
