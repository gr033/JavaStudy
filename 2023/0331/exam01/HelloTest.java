package exam01;

import java.util.Date;
class Hello extends Thread{
	public void run() {
		while(true) {
			Date day = new Date();
			int hh = day.getHours();
			int mm = day.getMinutes();
			int ss = day.getSeconds();
			System.out.println(hh+"시"+mm+"분"+ss+"초, 안녕하세요?");	
			try {
				sleep(1000);
			}catch(Exception e){}
		}
	}
}
public class HelloTest {
	public static void main(String[] args) {
		Hello h = new Hello();
		h.start();
	}	
}