package exam02;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
//			InetAddress addr = InetAddress.getByName("www.naver.com");
//			System.out.println(addr);
			InetAddress []add = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ad:add) {
				System.out.println(ad);
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
