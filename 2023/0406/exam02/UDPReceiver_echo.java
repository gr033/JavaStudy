package exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver_echo {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			byte []data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			while(true) {
				socket.receive(packet);
				//데이터를 받았을 때 보낸 측의 주소정보도 함꼐 옵니다.
				String message = new String(data);
				System.out.println("수신된 데이터: "+message);
				//수신한 데이터를 그대로 보냅니다. (메아리)
				socket.send(packet);
				Arrays.fill(data, (byte)0);
			}
			
		} catch (Exception e) {
			System.out.println("에외발생: "+e.getMessage());
		}
	}
}
